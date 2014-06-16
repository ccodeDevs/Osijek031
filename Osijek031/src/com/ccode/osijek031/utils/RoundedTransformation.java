package com.ccode.osijek031.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;

import com.squareup.picasso.Transformation;

/**
 * Title: CCode Osijek031 <br />
 * Copyright: Copyright @ 2014 <br />
 * 
 * @author Josip Jurisic
 * @version 1.0
 */

public class RoundedTransformation implements Transformation {

	private final int mRadius;
	private final int mMargin;

	public RoundedTransformation(int radius, int margin) {
		this.mRadius = radius;
		this.mMargin = margin;
	}

	@Override
	public Bitmap transform(final Bitmap source) {
		final Paint paint = new Paint();
		paint.setAntiAlias(true);
		paint.setShader(new BitmapShader(source, Shader.TileMode.CLAMP,
				Shader.TileMode.CLAMP));

		Bitmap output = Bitmap.createBitmap(source.getWidth(),
				source.getHeight(), Bitmap.Config.ARGB_8888);
		Canvas canvas = new Canvas(output);
		canvas.drawRoundRect(new RectF(mMargin, mMargin, source.getWidth()
				- mMargin, source.getHeight() - mMargin), mRadius, mRadius,
				paint);

		if (source != output) {
			source.recycle();
		}

		return output;
	}

	@Override
	public String key() {
		return "round";
	}
}