/*
 * Copyright 2014 - 2020 Michael Rapp
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package de.mrapp.android.dialog.animation;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;

import androidx.annotation.NonNull;
import de.mrapp.util.Condition;

/**
 * An animation, which can be used to show or hide a dialog by animating its position and size as a
 * clipping circle.
 *
 * @author Michael Rapp
 * @since 4.0.0
 */
@TargetApi(Build.VERSION_CODES.LOLLIPOP)
public class CircleRevealAnimation extends DialogAnimation {

    /**
     * A builder, which allows to create animations, which can be used to show or hide a dialog by
     * animating its position and size as a clipping circle.
     */
    public static class Builder
            extends AbstractDialogAnimationBuilder<CircleRevealAnimation, Builder> {

        /**
         * Creates a new builder, which allows to create animations, which can be used to show or
         * hide a dialog by animating its position and size as a clipping circle.
         *
         * @param context
         *         The context, which should be used by the builder, as an instance of the class
         *         {@link Context}. The context may not be null
         */
        public Builder(@NonNull final Context context) {
            super(context);
        }

        /**
         * Sets the horizontal position, which should be used by the animation, which is created by
         * the builder.
         *
         * @param x
         *         The horizontal position, which should be set, in pixels as an {@link Integer}
         *         value
         * @return The builder, this method has been called upon, as an instance of the class {@link
         * Builder}
         */
        public final Builder setX(final int x) {
            create().setX(x);
            return self();
        }

        /**
         * Sets the vertical position, which should be used by the animation, which is created by
         * the builder.
         *
         * @param y
         *         The vertical position, which should be set, in pixels as an {@link Integer}
         *         value
         * @return The builder, this method has been called upon, as an instance of the class {@link
         * Builder}
         */
        public final Builder setY(final int y) {
            create().setY(y);
            return self();
        }

        /**
         * Sets the radius, which should be used by the animation, which is created by the builder.
         *
         * @param radius
         *         The radius, which should be set, in pixels as an {@link Integer} value. The
         *         radius must be at least 0
         * @return The builder, this method has been called upon, as an instance of the class {@link
         * Builder}
         */
        public final Builder setRadius(final float radius) {
            create().setRadius(radius);
            return self();
        }

        @NonNull
        @Override
        protected final CircleRevealAnimation onCreateProduct() {
            return new CircleRevealAnimation(getContext());
        }

    }

    /**
     * The horizontal position, which is used by the animation.
     */
    private int x;

    /**
     * The vertical position, which is used by the animation.
     */
    private int y;

    /**
     * The radius, which is used by the animation.
     */
    private float radius;

    /**
     * Sets the horizontal position, which should be used by the animation.
     *
     * @param x
     *         The horizontal position, which should be set, in pixels as an {@link Integer} value
     */
    protected final void setX(final int x) {
        this.x = x;
    }

    /**
     * Sets the vertical position, wihch should be used by the animation.
     *
     * @param y
     *         The vertical position, which should be set, in pixels as an {@link Integer} value
     */
    protected final void setY(final int y) {
        this.y = y;
    }

    /**
     * Sets the radius, which should be used by the animation.
     *
     * @param radius
     *         The radius, which should be set, in pixels as a {@link Float} value. The radius must
     *         be at least 0
     */
    protected final void setRadius(final float radius) {
        Condition.INSTANCE.ensureAtLeast(radius, 0, "The radius must be at least 0");
        this.radius = radius;
    }

    /**
     * Creates a new animation, which can be used to show or hide a dialog by animating its position
     * and size as a clipping circle.
     *
     * @param context
     *         The context, which should be used by the animation, as an instance of the class
     *         {@link Context}. The context may not be null
     */
    protected CircleRevealAnimation(@NonNull final Context context) {
        super(context);
        this.x = 0;
        this.y = 0;
        this.radius = 0;
    }

    /**
     * Returns the horizontal position, which is used by the animation.
     *
     * @return The horizontal position, which is used by the animation, in pixels as an {@link
     * Integer} value
     */
    public final int getX() {
        return x;
    }

    /**
     * Returns the vertical position, which is used by the animation.
     *
     * @return The vertical position, which is used by the animation, in pixels as an {@link
     * Integer} value
     */
    public final int getY() {
        return y;
    }

    /**
     * Returns the radius, which is used by the animation.
     *
     * @return The radius, which is used by the animation, in pixels as a {@link Float} value
     */
    public final float getRadius() {
        return radius;
    }

}