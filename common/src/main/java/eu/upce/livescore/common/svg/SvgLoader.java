package eu.upce.livescore.common.svg;

import android.content.Context;
import android.graphics.drawable.PictureDrawable;
import android.net.Uri;
import android.util.Log;
import android.widget.ImageView;
import com.bumptech.glide.GenericRequestBuilder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.model.StreamEncoder;
import com.bumptech.glide.load.resource.file.FileToStreamDecoder;
import com.caverock.androidsvg.SVG;
import java.io.File;
import java.io.InputStream;
import java.util.Objects;

public class SvgLoader {

  private Context context;
  private GenericRequestBuilder<Uri, InputStream, SVG, PictureDrawable> requestBuilder;

  private SvgLoader(Context context) {
    this.context = context;
    createRequestBuilder();
  }

  public static SvgLoader with(Context context) {
    return new SvgLoader(context);
  }

  public SvgLoader setPlaceHolder(int placeHolderLoading, int placeHolderError){
    requestBuilder.placeholder(placeHolderLoading)
        .error(placeHolderError);
    return this;
  }

  public void load(String url, ImageView imageView){
    Uri uri = Uri.parse(url);
    load(uri, imageView);
  }

  public void load(Uri uri, ImageView imageView){
    requestBuilder
        .diskCacheStrategy(DiskCacheStrategy.SOURCE)
        .load(uri)
        .into(imageView);
  }

  public void close(){
    clearCache();
  }

  private void createRequestBuilder() {
    requestBuilder = Glide.with(context)
        .using(Glide.buildStreamModelLoader(Uri.class, context), InputStream.class)
        .from(Uri.class)
        .as(SVG.class)
        .transcode(new SvgDrawableTranscoder(), PictureDrawable.class)
        .sourceEncoder(new StreamEncoder())
        .cacheDecoder(new FileToStreamDecoder<>(new SvgDecoder()))
        .decoder(new SvgDecoder())
        .animate(android.R.anim.fade_in)
        .listener(new SvgSoftwareLayerSetter<>());
  }


  private void clearCache() {
    Glide.get(context).clearMemory();
    File cacheDir = Glide.getPhotoCacheDir(context);
    if (cacheDir.isDirectory()) {
      for (File child : Objects.requireNonNull(cacheDir.listFiles())) {
        if (!child.delete()) {
          Log.w(TAG, "cannot delete: " + child);
        }
      }
    }
  }

  private static final String TAG = "SvgLoader";
}