### VKU Notification App

## Overview

VKU Notification App is a mobile application designed to simplify and enhance the way students at VKU receive notifications and updates. The app crawls data from the VKU Education Portal, processes the information, and displays it in a user-friendly interface. It also integrates Google OAuth via Firebase for secure authentication.

## Features

- Data Crawling: Automatically fetches notifications from the VKU Education Portal using Cheerio.

- User Authentication: Secure login system with Firebase OAuth and Google integration.

- Real-Time Updates: Notifications are synced and displayed instantly on the Android app.


## Technologies Used

#### Backend: Node.js for server-side development.

- Data Crawling: Cheerio for web scraping and extracting information from the VKU Education Portal.

- Authentication: Firebase Authentication with Google OAuth.

#### Frontend: Android Studio with Java/Kotlin for building the mobile app.

- Database: Firebase Firestore for storing and syncing notification data.

- Hosting: Firebase Hosting for backend services.

## Installation and Setup

#### Backend

- Clone the repository:
```bash 
git clone https://github.com/yourusername/vku-notification-app.git
cd vku-notification-app
```
- Install dependencies:
```bash
npm install
```
#### Set up Firebase project:

- Go to the Firebase Console.

- Create a new project and enable Authentication and Firestore Database.

- Download the Firebase Admin SDK service account JSON file and place it in the backend directory.

- Configure environment variables:

- Create a .env file and add the following:

```bash
PORT=5000
FIREBASE_ADMIN_SDK_PATH=./path-to-your-service-account.json
VKU_PORTAL_URL=https://your-vku-portal-url.com
```

- Start the server:
```bash
npm start
```


#### Frontend

- Open the Android Studio project in the frontend directory.

- Connect the app to your Firebase project:

- Add the google-services.json file from Firebase to the app/ directory.

- Ensure Firebase Authentication and Firestore Database are enabled.

- Build and run the app on your Android device or emulator.