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
