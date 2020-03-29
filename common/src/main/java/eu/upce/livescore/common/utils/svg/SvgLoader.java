package eu.upce.livescore.common.utils.svg;

import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;

public class SvgLoader {

  private static SvgLoader instances;

  private SvgParser svgParser;

  public static SvgLoader pluck() {
    if (instances == null)
      instances = new SvgLoader();
    return instances;
  }

  public SvgLoader with(Context context){
    svgParser = new SvgParser(context);
    return instances;
  }

  public void close(){
    svgParser.clearCache();
  }

  public SvgLoader setPlaceHolder(int placeHolderLoading, int placeHolderError){
    svgParser.setPlaceHolder(placeHolderLoading, placeHolderError);
    return instances;
  }

  public SvgLoader load(String url, ImageView imageView){
    Uri uri = Uri.parse(url);
    svgParser.loadImage(uri, imageView);
    return instances;
  }

  public SvgLoader load(Uri uri, ImageView imageView){
    svgParser.loadImage(uri, imageView);
    return instances;
  }
}