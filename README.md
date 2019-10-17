# 💣💻🔨 ExitGame - Coding Challenge

[![Kotlin](https://img.shields.io/badge/Kotlin-1.3.40-blue.svg?style=flat&logo=kotlin&logoColor=white)](http://kotlinlang.org)
[![LibGDX](https://img.shields.io/badge/JUnit-5.5.1-25A162.svg)](https://junit.org/junit5/)
 
This coding challenge is part of an [ExitGame](https://github.com/TobseF/exit-game-bomb-app) where payers have to deactivate a bomb.

The Bomb runs on an Android device. It starts with a countdown before it explodes.
It's not accessible for the players. Players have to deactivate the bomb with this coding challenges.
The deactivation commands are sent to an REST interface of the [Bomb-App](https://github.com/TobseF/exit-game-bomb-app).

## [📚 Bomb Instruction Manual](https://github.com/TobseF/its-exit-game-bomb/releases/download/v0.0.1/Bomb.Instruction.Manual.pdf)
The players read the [Bomb Instruction Manual](https://github.com/TobseF/its-exit-game-bomb/releases/download/v0.0.1/Bomb.Instruction.Manual.pdf) which helps
them to solve the included tests. Print it for them.  
⚠ This README and the git repository contain information which should not visible for the ExitGame players. 

## 📱 Bomb App
The players solve the puzzle by trigger unit tests which access the bombs REST API.
1. **[Bomb-App](https://github.com/TobseF/exit-game-bomb-app)**  
  The app which runs on the bombs hardware.
2. **[Bomb-Client-App](https://github.com/TobseF/bomb-client-app)**  
  The admin UI which can change settings of the bomb an check the bombs state. This is of course not available for the players.

## 🚀 Start
Run the [JUnit](https://junit.org/junit5/) test int the `Module` class according the bomb manual.
