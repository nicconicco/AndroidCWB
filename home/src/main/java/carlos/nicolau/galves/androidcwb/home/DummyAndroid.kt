package carlos.nicolau.galves.androidcwb.home

import carlos.nicolau.galves.core.domain.Android

private const val COUNT = 10

object DummyAndroid {

    val ITEMS: MutableList<Android> = ArrayList()

    init {
        for (i in 1..COUNT) {
            addAndroid(createDummyItem(i))
        }
    }

    private fun createDummyItem(position: Int): Android {
        return when (position) {
            1 -> Android(
                name = "Android 1.0",
                apiLevel = 1,
                version = "1.0",
                history = "Android 1.0, the first commercial version of the software, was released on September 23, 2008.[33] The first commercially available Android device was the HTC Dream.[34] Android 1.0 incorporated the following features",
                date = "September 23, 2008",
                description = "Android Market allowed application downloads and updates through the Market application.\n" +
                        "Web browser to show, zoom and pan full HTML and XHTML web pages – multiple pages show as windows (\"cards\").[35][36]\n" +
                        "Camera support – however, this version lacked the option to change the camera's resolution, white balance, quality, etc.[37]\n" +
                        "Folders allowing the grouping of a number of application icons into a single folder icon on the Home screen.[38]\n" +
                        "Access to web email servers, supporting POP3, IMAP4, and SMTP.[36]\n" +
                        "Gmail synchronization with the Gmail application.\n" +
                        "Google Contacts synchronization with the People application.\n" +
                        "Google Calendar synchronization with the Calendar application.\n" +
                        "Google Maps with Street View to view maps and satellite imagery, as well as find local businesses and obtain driving directions using GPS.[37]\n" +
                        "Google Sync, allowing management of over-the-air synchronization of Gmail, People, and Calendar.\n" +
                        "Google Search, allowing users to search the Internet and phone applications, contacts, calendar, etc.\n" +
                        "Google Talk instant messaging.\n" +
                        "Instant messaging, text messaging, and MMS.\n" +
                        "Media Player, enabling management, importing, and playback of media files – however, this version lacked video and stereo Bluetooth support.[36][37]\n" +
                        "Notifications appear in the Status bar, with options to set ringtone, LED or vibration alerts.[35][36][39]\n" +
                        "Voice Dialer allows dialing and placing of phone calls without typing a name or number.[36]\n" +
                        "Wallpaper allows the user to set the background image or photo behind the Home screen icons and widgets.\n" +
                        "YouTube video player.[40]\n" +
                        "Other applications include: Alarm Clock, Calculator, Dialer (Phone), Home screen (Launcher), Pictures (Gallery), and Settings.\n" +
                        "Wi-Fi and Bluetooth support.",
                subDescription = "Android Project Open Source",
                icon = "alpha_v2"
            )
            2 -> Android(
                name = "Android 1.1",
                apiLevel = 2,
                version = "1.1",
                history = "On February 9, 2009, the Android 1.1 update was released, initially for the HTC Dream only. Android 1.1 was known as \"Petit Four\" internally, though this name was not used officially.[2][41] The update resolved bugs, changed the Android API and added a number of features",
                date = "February 9, 2009",
                description = "Details and reviews available when a user searches for businesses on Maps.\n" +
                        "Longer in-call screen timeout by default when using the speakerphone, plus the ability to show/hide the dialpad.\n" +
                        "Ability to save attachments in messages.\n" +
                        "Support added for marquee in system layouts.",
                subDescription = "Android Project Open Source",
                icon = "alpha_v2"
            )
            3 -> Android(
                name = "Android 1.5 Cupcake",
                apiLevel = 3,
                version = "1.5",
                history = "On April 27, 2009, the Android 1.5 update was released, based on Linux kernel 2.6.27.[43][44] This was the first release to officially use a codename based on a dessert item (\"Cupcake\"), a theme used for all releases until Android Pie, with Android 10 using a number-only system. The update included several new features and UI amendments",
                date = "April 27, 2009",
                description = "Support for third-party virtual keyboards with text prediction and a user dictionary for custom words.\n" +
                        "Support for Widgets – miniature application views that can be embedded in other applications (such as the Home screen) and receive periodic updates.[46]\n" +
                        "Video recording and playback in MPEG-4 and 3GP formats.\n" +
                        "Auto-pairing and stereo support for Bluetooth (A2DP and AVRCP profiles).\n" +
                        "Copy and paste features in web browser.\n" +
                        "User pictures shown for Favorites in Contacts.\n" +
                        "Specific date/time stamp shown for events in call log, and one-touch access to a contact card from a call log event.\n" +
                        "Animated screen transitions.\n" +
                        "Auto-rotation option.\n" +
                        "New stock boot animation.\n" +
                        "Ability to upload videos to YouTube.\n" +
                        "Ability to upload photos to Picasa.",
                subDescription = "Android Project Open Source",
                icon = "cupcake_v2"
            )
            4 -> Android(
                name = "Android 1.6 Donut",
                apiLevel = 4,
                version = "1.6",
                history = "On September 15, 2009, Android 1.6 – dubbed Donut – was released, based on Linux kernel 2.6.29.[47][48][49] Included in the update were numerous new features",
                date = "September 15, 2009",
                description = "Voice and text entry search enhanced to include bookmark history, contacts, and the web.\n" +
                        "Ability for developers to include their content in search results.\n" +
                        "Multi-lingual speech synthesis engine to allow any Android application to \"speak\" a string of text.\n" +
                        "Easier searching and the ability to view app screenshots in Android Market.\n" +
                        "Gallery, Camera and camcorder more fully integrated, with faster camera access.\n" +
                        "Ability for users to select multiple photos for deletion.\n" +
                        "Updated technology support for CDMA/EVDO, 802.1x, VPNs, and a text-to-speech engine.\n" +
                        "Support for WVGA screen resolutions.\n" +
                        "Speed improvements in searching and camera applications.\n" +
                        "Expanded Gesture framework and a new GestureBuilder development tool.",
                subDescription = "Android Project Open Source",
                icon = "donut_v2"
            )
            5 -> Android(
                name = "Android 2.0 Eclair",
                apiLevel = 5,
                version = "2.0",
                history = "On October 26, 2009, the Android 2.0 SDK was released, based on Linux kernel 2.6.29 and codenamed Eclair.[50] Changes include the ones listed below",
                date = "October 26, 2009",
                description = "Expanded Account sync, allowing users to add multiple accounts to a device for synchronization of an email and contacts.\n" +
                        "Microsoft Exchange email support, with a combined inbox to browse an email from multiple accounts in one page.\n" +
                        "Bluetooth 2.1 support.\n" +
                        "Ability to tap a Contacts photo and select to call, SMS, or email the person.\n" +
                        "Ability to search all saved SMS and MMS messages, with the added ability to delete the oldest messages in a conversation automatically deleted when a defined limit is reached.\n" +
                        "Numerous new camera features, including flash support, digital zoom, scene mode, white balance, color effect and macro focus.\n" +
                        "Improved typing speed on a virtual keyboard, with a smarter dictionary that learns from word usage and includes contact names as suggestions.\n" +
                        "Refreshed browser UI with bookmark thumbnails, double-tap zoom and support for HTML5.\n" +
                        "Calendar agenda view enhanced, showing attending status for each invitee, and the ability to invite new guests to events.\n" +
                        "Optimized hardware speed and revamped UI.\n" +
                        "Support for more screen sizes and resolutions, with better contrast ratio.\n" +
                        "Improved Google Maps 3.1.2.\n" +
                        "MotionEvent class enhanced to track multi-touch events.[52]\n" +
                        "Addition of live wallpapers, allowing the animation of home-screen background images to show movement.",
                subDescription = "Android Project Open Source",
                icon = "eclair_v2"
            )
            6 -> Android(
                name = "Android 2.0.1 Eclair",
                apiLevel = 6,
                version = "2.0.1",
                history = "",
                date = "December 3, 2009",
                description = "Minor API changes, bug fixes and framework behavioral changes.",
                subDescription = "Android Project Open Source",
                icon = "eclair_v2"
            )
            7 -> Android(
                name = "Android 2.1 Eclair",
                apiLevel = 7,
                version = "2.1",
                history = "",
                date = "January 12, 2010",
                description = "Minor amendments to the API and bug fixes.",
                subDescription = "Android Project Open Source",
                icon = "eclair_v2"
            )
            8 -> Android(
                name = "Android 2.2 Froyo",
                apiLevel = 8,
                version = "2.2",
                history = "On May 20, 2010, the SDK for Android 2.2 (Froyo, short for frozen yogurt) was released, based on Linux kernel 2.6.32",
                date = "May 20, 2010",
                description = "Speed, memory, and performance optimizations.[56]\n" +
                        "Additional application speed improvements, implemented through JIT compilation.[57]\n" +
                        "Integration of Chrome's V8 JavaScript engine into the Browser application.\n" +
                        "Support for the Android Cloud to Device Messaging (C2DM) service, enabling push notifications.\n" +
                        "Improved Microsoft Exchange support, including security policies, auto-discovery, GAL look-up, calendar synchronization and remote wipe.\n" +
                        "Improved application launcher with shortcuts to Phone and Browser applications.\n" +
                        "USB tethering and Wi-Fi hotspot functionality[58]\n" +
                        "Option to disable data access over a mobile network.\n" +
                        "Updated Market application with batch and automatic update features.[56]\n" +
                        "Quick switching between multiple keyboard languages and their dictionaries.\n" +
                        "Support for Bluetooth-enabled car and desk docks.\n" +
                        "Support for numeric and alphanumeric passwords.\n" +
                        "Support for file upload fields in the Browser application.[59]\n" +
                        "The browser now shows all frames of animated GIFs instead of just the first frame only.\n" +
                        "Support for installing applications to expandable memory.\n" +
                        "Adobe Flash support.[60]\n" +
                        "Support for high-PPI displays (up to 320 ppi), such as four-inch 720p screens.[61]\n" +
                        "Gallery allows users to view picture stacks using a zoom gesture.\n" +
                        "2.2.1 - Bug fixes, security updates and performance improvements.\n" +
                        "2.2.2 - Minor bug fixes, including SMS routing issues that affected the Nexus One.\n" +
                        "2.2.3 - Two security updates.",
                subDescription = "Android Project Open Source",
                icon = "froyo_v2"
            )
            9 -> Android(
                name = "Android 2.3 Gingerbread",
                apiLevel = 9,
                version = "2.3",
                history = "On December 6, 2010, the Android 2.3 (Gingerbread) SDK was released, based on Linux kernel 2.6.35.[64][65] Changes included",
                date = "December 6, 2010",
                description = "Updated user interface design with increased simplicity and speed.\n" +
                        "Support for extra-large screen sizes and resolutions (WXGA and higher).[61]\n" +
                        "Native support for SIP VoIP internet telephones.\n" +
                        "Faster, more intuitive text input on a virtual keyboard, with improved accuracy, better suggested text and voice input mode.\n" +
                        "Enhanced copy/paste functionality, allowing users to select a word by press-holding, copying, and pasting.\n" +
                        "Support for Near Field Communication (NFC), allowing the user to read an NFC tag embedded in a poster, sticker, or advertisement.\n" +
                        "New audio effects such as reverb, equalization, headphone virtualization, and bass boost.\n" +
                        "New Download Manager, giving users easy access to any file downloaded from the browser, email, or another application.\n" +
                        "Support for multiple cameras on the device, including a front-facing camera, if available.\n" +
                        "Support for WebM/VP8 video playback, and AAC audio encoding.\n" +
                        "Improved power management with a more active role in managing applications that are keeping the device awake for too long.\n" +
                        "Enhanced support for native code development.\n" +
                        "Switched from YAFFS to ext4 on newer devices.[66][67]\n" +
                        "Audio, graphical, and input enhancements for game developers.\n" +
                        "Concurrent garbage collection for increased performance.\n" +
                        "Native support for more sensors (such as gyroscopes and barometers).\n" +
                        "First Android version to feature an Easter egg. It was an image of the Bugdroid standing next to a zombie gingerbread man, with many more zombies in the background.\n" +
                        "2.3.1 - Improvements and bug fixes for the Nexus S.\n" +
                        "2.3.2 - Improvements and bug fixes for the Nexus S.",
                subDescription = "Android Project Open Source",
                icon = "gingerbread_v2"
            )
            10 -> Android(
                name = "Android 2.3.3 Gingerbread",
                apiLevel = 10,
                version = "2.3.3",
                history = "Several improvements and API fixes\n" +
                        "Support for voice or video chat using Google Talk.[70]\n" +
                        "Open Accessory Library support. Open Accessory was introduced in 3.1 (Honeycomb) but the Open Accessory Library grants 2.3.4 added support when connecting to a USB peripheral with compatible software and a compatible application on the device.[71]\n" +
                        "Switched the default encryption for SSL from AES256-SHA to RC4-MD5.[72][73]\n" +
                        "Fixed a spontaneous reboot on Samsung Galaxy S Plus.\n" +
                        "Improved network performance for the Nexus S 4G, among other fixes and improvements.\n" +
                        "Fixed a Bluetooth bug on Samsung Galaxy S.\n" +
                        "Fixed a Wi-Fi crash on Samsung Galaxy S Plus.\n" +
                        "Improved the Gmail application.\n" +
                        "Shadow animations for list scrolling.\n" +
                        "Camera software enhancements.[74]\n" +
                        "Improved battery efficiency.\n" +
                        "Fixed a voice search bug.\n" +
                        "Google Wallet support for the Nexus S 4G.",
                date = "February 9, 2011",
                description = "Updated user interface design with increased simplicity and speed.\n" +
                        "Support for extra-large screen sizes and resolutions (WXGA and higher).[61]\n" +
                        "Native support for SIP VoIP internet telephones.\n" +
                        "Faster, more intuitive text input on a virtual keyboard, with improved accuracy, better suggested text and voice input mode.\n" +
                        "Enhanced copy/paste functionality, allowing users to select a word by press-holding, copying, and pasting.\n" +
                        "Support for Near Field Communication (NFC), allowing the user to read an NFC tag embedded in a poster, sticker, or advertisement.\n" +
                        "New audio effects such as reverb, equalization, headphone virtualization, and bass boost.\n" +
                        "New Download Manager, giving users easy access to any file downloaded from the browser, email, or another application.\n" +
                        "Support for multiple cameras on the device, including a front-facing camera, if available.\n" +
                        "Support for WebM/VP8 video playback, and AAC audio encoding.\n" +
                        "Improved power management with a more active role in managing applications that are keeping the device awake for too long.\n" +
                        "Enhanced support for native code development.\n" +
                        "Switched from YAFFS to ext4 on newer devices.[66][67]\n" +
                        "Audio, graphical, and input enhancements for game developers.\n" +
                        "Concurrent garbage collection for increased performance.\n" +
                        "Native support for more sensors (such as gyroscopes and barometers).\n" +
                        "First Android version to feature an Easter egg. It was an image of the Bugdroid standing next to a zombie gingerbread man, with many more zombies in the background.",
                subDescription = "Android Project Open Source",
                icon = "gingerbread_v2"
            )
            else -> Android(

            )
        }
    }

    private fun addAndroid(android: Android) {
        ITEMS.add(android)
    }
}