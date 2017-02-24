# Viscera

The Viscera plugin is a tiny framework, which helps to use MVP pattern with a Dependency Injection (DI).
It was built completely without any reflection, nor code generation (yet), using generic programming.
The main approach is to have dummy Views, which are controlled by presenters through interfaces using a simple DI system.

Please, have a look at the **example** project.

### How to use

There are modules, which are used to combine a `View` layer with a `Presenter` for each module.

## MVP

**View**

There is an interface `Screen`, which is something, that can show content and has `android.content.Context`. It can either be an `Activity`, or a `View`, or a `Fragment` (in the last two you don't even have to override the `Screen.getContext();` method as they already have it).

```java
public interface MainScreen implements Screen {

    MainScreen setTitle(int titleResource);

    MainScreen showDialog(int messageResource, int iconDrawable);

}
```

**Presenter**

There is a `Presenter` class:

```java
public class MainPresenter extends Presenter<MainScreen> {

    @Override
    public void addView(MainScreen screen) {
        saveScreen(screen);
        screen.setTitle(R.string.title);
    }

    @Override
    public void updateView(MainScreen screen) {
        screen.showDialog(R.string.message, R.drawable.main_message);
    }

}
```

Viscera plugin also provides an optional `State` helper, which can help to manage states of some android views.


```java
public class CoolState extends State<SuperPresenter> {

    @Override
    public void apply(ViewGroup root, SuperPresenter presenter) {
        View.inflate(root.getContext(), R.layout.example, root);
        TextView label = (TextView) root.findViewById(R.id.label_text);
        label.setText("Hello, world!");
    }
}

```


**Model**

The model part of an application can be developed without any additional abstractions.

## Dependency Injection

**Application Module**

A *Module* plays a role of an injector and injects a *Screen* into a *Presenter*. Also it can inject some other objects, which may be needed to a *Presenter*: Model objects (e.g. DatabaseHelper), Web Clients, non-static Helper classes etc.

```java
public class MainModule implements Module<MainScreen> {
    private Presenter<MainScreen> mPresenter;

    @Override
    public MainModule attach(MainScreen screen) {
        mPresenter = new MainPresenter();
        mPresenter.addView(screen);
    }

    @Override
    public MainModule update(MainScreen screen) {
        mPresenter.updateView(screen);
    }

    @Override
    public MainModule detach(MainScreen screen) {
        mPresenter = null;
    }
}
```

You also can use a *GenericModule* class to ease your module, thus you won't need to override `update(Screen)` and `detach(Screen)` if you don't need to (as it isn't actually needed in a listing above).

**Initialization of modules**

After some module was created, it must be instantiated and injected by using *Container*.
The *Container* class contains all *Module* instances and provides an access to them.

```java
public class AwesomeApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Container.getInstance().put(new MainModule());
    }
}
```

**Accessing modules, updating presenters**

To access and use *Presenters* inside *Screens*:

```java
public class MainActivity extends Activity implements SomeScreen {

    private MainModule mModule;

    @Override
    public void onCreate(Bundle savedState) {
        super.onCreate(savedState);
        mModule = Container.getInstance().get(MainModule.class);
        // Make sure to init your widgets before calling attach().
        mModule.attach(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        // Do it carefully and only if you really
        // need to update when the onUpdate() is called!
        mModule.update(this);
    }

    @Override
    public void onDestroy() {
        mModule.detach(this);
    }

    public void receiveAction() {
        // If you want to update content when some action
        // was received or within callback etc
        mModule.update(this);
    }

    ...

}

```

## Integration
The library is published to the jcenter repository, thus your *project's* `build.gradle` must contain:

```groovy
repositories {
    jcenter()
}
```

To use this library add following to your *module's* `build.gradle`:

```groovy
dependencies {
    compile 'com.yotadevices.viscera:core:0.3.1'
}
```

### Why to use
It is tiny (8Kb jar without Proguard) and simple.
It is quite useful for small and medium projects (There are no huge projects built upon the Viscera framework). However, for big projects you'd maybe prefer to use something like *Moxy* with something like *Dagger 2*.

### TODO
`Container.getInstance().get(MainModule.class).attach(this).update(this);`. Maybe it is useful, pretty ugly, though.
Also, there is some code, which we don't actually want to write (e.g. init module in an `Application` class or making a `Module` by ourself).
* Cover with unit tests;
* Enable Proguard;
* Add code generation, which would make decorator to attach screens to modules, update modules and detach screens from them;
* Add code generation, which would make Module instances only using an information about declared `Screens` and `Presenters`.

### License
```Text
Copyright (C) 2017 Yota Devices LLC, Russia

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
