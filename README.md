# Speedo Transfer

### Description
Speedo Transfer is a banking app that allows users to manage their finances efficiently by creating accounts, viewing balances, managing transactions, and sending money securely to other users.

### Features
1. **Onboarding Screens**: Users can learn about the app through onboarding screens, shown only the first time the app is used.
2. **Account Creation**: Users can create a profile with their name, email, password, country and date of birth. Passwords must meet security criteria: 6 characters, including one capital letter, one small letter, and a special character.
3. **Login**: Users can log in to their account using credentials.
4. **Account Balance**: Users can view their account balance to track available funds.
5. **Transaction History**: Users can view their transaction history, including date, recipient name, and amount.
6. **Send Money**: Users can transfer funds to other users by entering recipient details (name, account number) and verifying via an API call.
7. **Transaction Confirmation**: Users receive a confirmation/notification upon successful transactions.
8. **Error Handling**: Error messages are provided during transactions for issues like insufficient funds or invalid recipient details.
9. **Profile Updates**: Users can update their email, country, DOB, or password.
10. **Support Options**: Users can contact support via phone or email.
11. **Inactivity Alerts**: Users are logged out after two minutes of inactivity.
12. **Favorite Recipients**: Users can save, edit, and delete favorite recipients.
13. **Server/Connection Errors**: The app informs users of server errors or connection issues through specified screens.

15. ### Tech Stack
- **Jetpack Compose**: A modern toolkit for building native Android UIs with a declarative approach.
- **Kotlin**: The primary programming language used for Android development, known for its concise syntax and modern features.
- **Retrofit**: A type-safe HTTP client for Android that makes it easy to connect to RESTful web services.
- **OkHttp**: A popular HTTP & HTTP/2 client for Android that’s used with Retrofit for handling network requests.
- **Jackson**: A library for serializing and deserializing JSON data. Specifically, we use:
  - **Jackson Kotlin Module**: To work with Kotlin classes.
  - **Jackson JSR-310**: For handling Java 8 Date/Time APIs.

#### Key Android Libraries:
- **AndroidX Core KTX**: Provides Kotlin extensions for common framework APIs, making Android development more concise and idiomatic.
- **Lifecycle Runtime KTX**: Helps manage the Android lifecycle by allowing developers to handle lifecycle-aware components more easily.
- **Activity Compose**: Integrates Jetpack Compose with Android activities, enabling the use of Compose in activity-based projects.
- **Material3**: Provides UI components based on Material Design 3, offering a modern look and feel for Android apps.
- **Navigation Compose**: A Jetpack library that enables in-app navigation using a declarative approach with Jetpack Compose.
- **Kotlinx Serialization**: A Kotlin serialization library used for parsing and generating JSON data.

  #### Screenshots from the App
![ssss](https://github.com/user-attachments/assets/01afd173-86de-4333-a8b9-eb697e939ee1)

![image](https://github.com/user-attachments/assets/7d34bb2e-9275-4266-b965-7f749bde0a72)

![image](https://github.com/user-attachments/assets/8b6c4cf0-043a-4070-b24f-ccab7e6e3ed0)

![image](https://github.com/user-attachments/assets/995b2227-b5d6-4601-aed7-b51c29c2583d)

![image](https://github.com/user-attachments/assets/86f61a54-2582-4ae1-a44e-71347d0d7c19)

![image](https://github.com/user-attachments/assets/1b376a35-a5d0-4fad-b33d-de7de4fba6e2)

![image](https://github.com/user-attachments/assets/7347adbb-5f70-48d1-9519-2256c75a695f)

![image](https://github.com/user-attachments/assets/b5680e78-a093-46af-974f-e2baa506bd76)

![image](https://github.com/user-attachments/assets/ee6b7e4a-a228-4369-b970-8db7f7de241f)

![image](https://github.com/user-attachments/assets/ec6597aa-ee4c-4804-a7fe-48b639b3102e)

![image](https://github.com/user-attachments/assets/e5d6f1a0-26ab-4586-9067-f7216e2aa71c)

![image](https://github.com/user-attachments/assets/6a71e6cd-5a05-498c-8dc5-337c1be15aed)



