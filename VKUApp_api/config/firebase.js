const admin = require("firebase-admin");
const serviceAccount = require("../serviceAccountKey.json"); // Path to the downloaded service account key JSON file

admin.initializeApp({
    //  your key
  });

  
const db = admin.firestore();

module.exports = { admin, db };