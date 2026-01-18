# Tic Tac Toe Android App

A classic Tic Tac Toe game for Android devices, built with Kotlin following the MVC (Model-View-Controller) architecture pattern.

## Contributors

- **Ofek Hogi** (ofekhogi1@gmail.com)
- **Shahar Arami** (aramio971@gmail.com)

## Features

- Two-player gameplay on a single device
- Player X and Player O alternate turns
- Score tracking across multiple games
- Win detection for all possible winning combinations
- Draw detection when the board is full
- Play Again button to start a new game
- Clean Material Design 3 UI
- MVC architecture for clean separation of concerns

## Technical Details

### Architecture

The app follows the **MVC (Model-View-Controller)** design pattern:

- **Model** (`TicTacToeGame.kt`): Contains all game logic including board state, player management, win/draw detection, and score tracking. No Android or UI dependencies.

- **View** (`activity_main.xml`): Defines the UI layout using XML. Includes a 3x3 grid of buttons, status display, score display, and play again button.

- **Controller** (`MainActivity.kt`): Bridges the Model and View. Handles user interactions, updates the UI based on game state, and delegates all game logic to the Model.

### Technology Stack

- **Language**: Kotlin
- **Minimum SDK**: API 21 (Android 5.0 Lollipop)
- **Target SDK**: API 34 (Android 14)
- **Build System**: Gradle with Kotlin DSL
- **UI Framework**: Material Design 3 Components
- **View Binding**: Enabled for type-safe view access

### Game Rules

1. Player X always goes first
2. Players alternate turns by clicking on empty cells
3. The first player to get 3 of their marks in a row (horizontally, vertically, or diagonally) wins
4. If all 9 cells are filled and no player has won, the game is a draw
5. Scores are tracked across multiple games
6. Click "Play Again" to start a new game (scores persist)

## How to Run

### Prerequisites

- Android Studio (Arctic Fox or later)
- Android SDK (API 21 or higher)
- Kotlin plugin

### Steps

1. Clone this repository:
   ```bash
   git clone https://github.com/ofekhogi1/TicTacToe.git
   cd TicTacToe
   ```

2. Open the project in Android Studio:
   - File → Open → Select the project folder

3. Wait for Gradle sync to complete

4. Run the app:
   - Connect an Android device or start an emulator
   - Click the "Run" button (green triangle) or press Shift+F10
   - Select your device/emulator

## Project Structure

```
TicTacToe/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/tictactoe/
│   │   │   │   ├── model/
│   │   │   │   │   └── TicTacToeGame.kt       # Game logic (Model)
│   │   │   │   └── MainActivity.kt             # Controller
│   │   │   ├── res/
│   │   │   │   ├── layout/
│   │   │   │   │   └── activity_main.xml       # UI layout (View)
│   │   │   │   └── values/
│   │   │   │       ├── strings.xml
│   │   │   │       ├── colors.xml
│   │   │   │       └── themes.xml
│   │   │   └── AndroidManifest.xml
│   │   └── test/
│   └── build.gradle.kts
├── build.gradle.kts
├── settings.gradle.kts
└── README.md
```

## Assignment Details

This project was developed as Assignment 1 for the Cellular Apps course, demonstrating:

- Understanding of Android OS architecture for mobile devices
- Kotlin programming with modular design
- MVC architecture with clear separation of concerns
- Synchronous UI design and interaction
- Building user interfaces for mobile devices
- Android app development workflow

## License

This project is created for educational purposes as part of a college assignment.

## Screenshots

The app features:
- A clean, modern Material Design interface
- Large, easy-to-tap buttons for gameplay
- Clear status indicators showing whose turn it is
- Score tracking display at the top
- Responsive layout that works on different screen sizes

---

**Course**: Cellular Apps Development
**Assignment**: Assignment 1 - Tic Tac Toe Game
**Year**: 2026
