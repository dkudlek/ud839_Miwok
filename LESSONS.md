# Lesson 1: multiple screen → multiple activity

- 4 activities/tabs/fragements, maybe with images, always with sound, scrollable list
- no splash screen → jump directly into app
- to import a project from github:
 1. download project
 1. open AndroidStudio
 1. Choose File → Import Project → select the folder
 1. install required SDKs
- for direct inclusion from github:
   1. Fork this repository to your GitHub account.
   1. Open Android Studio.
   1. File -> New -> Project from version control - GitHub
   1. Paste a link from your repository of the forked Miwok app, push Clone.
   1. Agree the presented terms. Update everything that's asked
   1. Launch on the device
- Intents move the Context from e.g. MainActivity to another Activity (NumbersActivity)
- create a new activity:
  1. app → new activity → fill form → finish
  1. see AndroidManifest.xml for changes → a new activity is listed
- icon in AndroidManifest.xml defines symbol for all apps screen
- intent-filter can specify which request can be performed by an activity
- use Textview as Button and set onClick() property → lookup, how the onClick property is implemented in java by checking the onClick documentation
- start intent:
  1. Intent intent = new Intent(<current_context>, activity.class) → the current context shows entry point from which the new activity is started, so the back button can move back to the previous activity
  1. startActivity(intent)
- implicit and explicit intent:
  - implicit e.g. mail app → some app that can handle and email → implicit needs to be guard for cases where there aren’t any apps installed to handle that Intent
  - explicit intent → specify the exact activity we want to use → use the mostly within the same app → the particular third party app called may not be installed on the device
- to change the title of a new activity, use the “android:label“ attribute
- Event Listener → instead of using XML attributes, use Java directly → for onClick, create a OnClickListener and attach it to the intended view with the setOnClickListener method → create inline function:
```java
numbers.setOnClickListener(new OnClickListener(){
    @Override
    public void onClick(View view){
    //do something here;
    }
}) ;
```
- OnClickListener vs onClick XML-attribute → decouple design and function →  sometimes you don’t need an action for onClick, but if you specitfy it in the XML then you have to implement it, otherwise the app will fail (there are also other uses, like in fragements) → best practice is an OnClickListener
- different classes:
 - Concrete Class → can be used right away
 - Abstract Class → needs to be subclassed
 - Interface → needs to be implemented

# Lesson 2:  ArrayAdapter for lists

- Array vs ArrayList: fixed vs. variable sizes
 - Array:
   - fixed length
   - creation: String[] words = new String[10];
   - use for e.g. week days in an alarm as boolean; categories in android play store
 - ArrayList:
   - size can grow or shrink
   - no primitive datatypes! → but object grabbers! → ArrayList<int> → ArrayList<Integer>
   - use for e.g. WLAN networks, Playlist in youtube
   ```java
   //creation
   arrayList<String> restaurantsToTry =
       new ArrayList<String>();
   ```
- add TextViews with Text from ArrayList in View
- create layout with vertical layout and add id ```rootView``` to dynamically add views with code
- get rootView by ID and add a new TextView with ```.addView()```
- for element in ArrayList: create TextView and add it to the View
- there is limited memory!
- no need to create 1000 TextViews when only 5 to 7 can be shown → view recycling → list + adapter
- enable memory monitor:
 - Android Studio → Tools → Android → Enable ADB integration
 - 6: Android Monitor → memory
- when to recycle:
  - e.g. twitter app requires recycling
  - e.g. fitness summary does not
- array adapter
  - creating a adapter and setting it on a ListView in the layout files
```java
ListView listView = (ListView) findViewById(R.id.list);
listView.setAdapter(itemsAdapter);
```

- ListView is powered by Adapter: Adapter holds data and adapts it to the ListView
- ListView asks how many elements are in the list
- ListView passes the position in the list and the adapter creates a View and returns it to the ListView
- adapter recycles views
- even spinners use adapters!
- create a specific layout to use custom views (e.g. layout with multiple TextViews)
- create custom WordAdapter for miwok app and override the getView method
- constructor gets context, layout (= 0 if custom layout gets inflated) and ArrayList of things  
- getView takes: position → in ArrayList, convertView → to recycle, parent
 - reuse view or inflate (if convertView == null) new view
- get the layout, use findById on the layout to populate it with data
- multiple layouts in adapter
- Android Tools Project → xmlns:tools → tools:text for TextView
- create a Word Object with name and translation

# Lesson 3: Practice

# Lesson 4: Images and Visual Polish

- partition task into smaller tasks → prioritize higher risk items and implement them first
- add images to miwok
 1. change layout
   - add HorizontalLayout
   - add ImageView into Horizontal LinearLayout and move Vertical LinearLayout into Horizontal LinearLayout (nested view groups)
   - temporarily add Image as XML src attribute
 1. add assets (images, sounds, etc.) → “assets drop”
   - import all drawable folders
 1. in the adapter:
   - get the TextView from the Layout and use setImageResourceId by taking the Image-ID from the Word class
 1. fix the phrases view that has no image content:
   - options:
     - create phrases adapter → only with TextView, no ImageView (only usable in 1 of 4 views) → same model would be better
     - hide view → setVisibility()  → View.{VISIBLE, INVISIBLE, GONE}
   - use condition on which to show a image view
   - static → associated with a class
   - final → never change value (const in c++)
   - in Word Class:
      - create new Constant with value “-1” → outside  of all valid ids
      - initialize mImageResourceId to “-1” → if it is different from -1, then there is a image
   - in Adapter → check if image available → if no image, set visibility of the imageView to “gone”
- different image sizes in assets (mdpi, hdpi, xhdpi, ..) → otherwise Android will shrink or grow the image
- always access resources by id → don’t save whole files in an object or program
- Visual Polish:
  1. redlines from designer → font size, font, spaces, colors
  1. remove padding from list_view
  1. set height value in dimens files
    - set minHeight on Layout instead of height (e. g. at least 88dp)
    - set height and width of ImageView to the same value (88dp x 88dp)
  1. Set color in color.xml file → Set color with android:background on the LinearLayout that contains the two TextViews
  1. set textAppearance to ?android:textAppearanceMedium
  1. set textColor color/ white
  1. set textStyle to bold
  1. center TextView →
    - set layoutWeigths : space divided evenly
    - set gravity (bottom/top)
  1. store background in WordAdapter → one WordAdapter per List → one color per list
    - WordAdapter should save color resource id
    - remove place-holding color in WordLayout (revert change d)
    - set color programmatically by fetching the View containing the two text elements and then change its color

# Lesson 5: Activity Lifecycle and Audio Playback

- play Media with MediaPlayer → has example code
- what is a AudioManager
- create a sample app to test new technologies:
  1. create new app
  1. right click on res folder → click new → create raw folder with type raw
  1. add the sound file to raw
  1. check Providing resources in Android
  1. add two buttons with onClickListener for play and pause
  1. initialize MediaPlayer in th MainActivity class → it is ready when we need it
    - ``mediaPlayer.start()``
    - ``mediaPlayer.pause()``
  1. MediaPlayer has states
- apply new knowledge
- add onClickListener for each Word object
- create MediaPlayer in ViewAdapter
- anonymous class → when you override just one function
- Media:
  - override the onItemClick function → create a MediaPlayer and play the song → pass context and resourceId (AudioMedia is one private object)
  - save audio resource ID in Word class → ArrayList needs to final to be accessed bei OnItemClickListener
- classes can have a toString method for easy debugging
- asynchronous callbacks: notify if certain event is happening (e.g. listeners) → common pattern
- others, e. g. AudioFinished callback (onCompletion) → modify AudioApp to show a toast message → set it after start has been called
- Cleaning up memory → release the media immediately after finishing the audio file → don’t “hope” that the user clicks the same Item again → use listener
- release and set MediaPlayer = null
- each Activity has all state methgods (onCreate, onPause, onDestroy) → don’t forget to call the super class method before you make any action
  - audio focus manages all audio outputs on the device
[How to properly handle audio interruptions by Developer Advocate Joanna Smith](https://medium.com/google-developers/how-to-properly-handle-audio-interruptions-3a13540d18fa#.jkibca8ml)
  - [Managing Audio Focus](http://developer.android.com/training/managing-audio/audio-focus.html)
- AudioMangager gives audio focus
  - requestAudioFocus(...)
  - abandonAudioFOcus(...)
  - callbacks:
    - onAudioFocusChange (LOSS_TRANSIENT or LOSS)
  - streamTypes: STREAM_ALARM, STREAM_MUSIC
  - durationHints: GAIN_TRANSIENT, GAIN_TRANSIENT_MAY_DUCK, …
- set AudioManger → getSystemService(Context.AUDIO_SERVICE)
- modify Program:
  - OnClickListener: → int i = request AudioFocus(callback, type, focus: GAIN_TRANSIET)
  - private member: OnAudioFocusChangeListener
    - implement reaction (focusChange) → pause, resume (→ restart), stop
  - releaseMediaPlayer: abandon AudioFocus
- add play arrow to layout
- touch feedback: android:background = “?android:attr/selectableItemBackground” → use frameLayout around the TextView to:
  - get the right color background, now used in FrameLayout
  - get the click ripple background on the TextView (color + animation)

# Lesson 6: Fragments → View Pager

- navigation pattern:
  - master-detail layout
  - drawer
  - swipeable
- implement UP button:
  - define android:parentActivityName in activity
- refactor for better User Experience
  - refactor: e.g. change design without changing functionality
  - regression: losing functionality when refactoring
- ViewPager with Adapter
  - FragmentStateAdapter vs. FragmentAdapter: → one saves whole fragment and the other only the state to recreate it
  - degrade activities to fragments (inherit from Fragment)
  - Adapter manages all fragment activities and shows available activity
  - Fragment has own lifecycle
  - create blank Fragment and copy code
  - errors:
    - get the view from the thr rootView instead of calling findViewById directly
    - can not make system call directly → get surrounding activity first
    - getActivity() and pass it to WordAdapter
    - getActivity() gain for the Mediaplayer instead of <Activity>.this
  - create one activity layout with ID
  - do some woodoo
- add tabs:
  -add support library in grade file
