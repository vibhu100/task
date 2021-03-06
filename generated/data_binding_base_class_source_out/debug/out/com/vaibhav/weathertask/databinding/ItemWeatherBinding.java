// Generated by data binding compiler. Do not edit!
package com.vaibhav.weathertask.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.vaibhav.weathertask.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ItemWeatherBinding extends ViewDataBinding {
  @NonNull
  public final TextView tvHour;

  @NonNull
  public final TextView tvHumid;

  @NonNull
  public final TextView tvHumidity;

  @NonNull
  public final TextView tvTemp;

  @NonNull
  public final TextView tvTemperature;

  @NonNull
  public final TextView tvTime;

  @NonNull
  public final TextView tvWind;

  @NonNull
  public final TextView tvWindSpeed;

  protected ItemWeatherBinding(Object _bindingComponent, View _root, int _localFieldCount,
      TextView tvHour, TextView tvHumid, TextView tvHumidity, TextView tvTemp,
      TextView tvTemperature, TextView tvTime, TextView tvWind, TextView tvWindSpeed) {
    super(_bindingComponent, _root, _localFieldCount);
    this.tvHour = tvHour;
    this.tvHumid = tvHumid;
    this.tvHumidity = tvHumidity;
    this.tvTemp = tvTemp;
    this.tvTemperature = tvTemperature;
    this.tvTime = tvTime;
    this.tvWind = tvWind;
    this.tvWindSpeed = tvWindSpeed;
  }

  @NonNull
  public static ItemWeatherBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_weather, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ItemWeatherBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ItemWeatherBinding>inflateInternal(inflater, R.layout.item_weather, root, attachToRoot, component);
  }

  @NonNull
  public static ItemWeatherBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_weather, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ItemWeatherBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ItemWeatherBinding>inflateInternal(inflater, R.layout.item_weather, null, false, component);
  }

  public static ItemWeatherBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static ItemWeatherBinding bind(@NonNull View view, @Nullable Object component) {
    return (ItemWeatherBinding)bind(component, view, R.layout.item_weather);
  }
}
