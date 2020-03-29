package eu.upce.livescore.common.utils.svg;

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

public class SvgParser {

  private final Context context;

  private GenericRequestBuilder<Uri, InputStream, SVG, PictureDrawable> requestBuilder;

  public SvgParser(Context context) {
    this.context = context;
    createRequestBuilder();
  }

  private void createRequestBuilder() {
    requestBuilder = Glide.with(context)
        .using(Glide.buildStreamModelLoader(Uri.class, context), InputStream.class)
        .from(Uri.class)
        .as(SVG.class)
        .transcode(new SvgDrawableTranscoder(), PictureDrawable.class)
        .sourceEncoder(new StreamEncoder())
        .cacheDecoder(new FileToStreamDecoder<SVG>(new SvgDecoder()))
        .decoder(new SvgDecoder())
        .animate(android.R.anim.fade_in)
        .listener(new SvgSoftwareLayerSetter<>());
  }

  public void setPlaceHolder(int placeHolderLoding, int placeHolderError){
    requestBuilder.placeholder(placeHolderLoding)
        .error(placeHolderError);
  }


  public void loadImage(Uri uri, ImageView imageView) {
    requestBuilder
        .diskCacheStrategy(DiskCacheStrategy.SOURCE)
        .load(uri)
        .into(imageView);
  }

  public void clearCache() {
    Glide.get(context).clearMemory();
    File cacheDir = Glide.getPhotoCacheDir(context);
    if (cacheDir.isDirectory()) {
      for (File child : cacheDir.listFiles()) {
        if (!child.delete()) {
          Log.w(TAG, "cannot delete: " + child);
        }
      }
    }
  }

  private static final String TAG = "SvgParser";
}

