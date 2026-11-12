# Escape Room: The Final Lock

A Java OOP console-based escape room project for a first/second-year CSE semester assignment.

## Project Overview
The player explores several rooms, solves interconnected puzzles, collects clues and items, unlocks doors, and ultimately escapes by solving the Final Lock.

## Features
- Main menu with Start Game, Instructions, and Exit
- Player name input
- Multiple rooms with descriptions and exploration
- ArrayList-based inventory system
- Multiple puzzle types: riddle, code, and logic
- Clues and collectible items
- Door and progression logic
- Score tracking with penalties
- Final escape challenge

## Project Structure

```text
EscapeRoom/
├── src/
│   └── main/
│       └── java/
│           ├── Main.java
│           ├── game/
│           │   └── Game.java
│           ├── player/
│           │   └── Player.java
│           ├── room/
│           │   └── Room.java
│           ├── puzzle/
│           │   ├── Puzzle.java
│           │   ├── RiddlePuzzle.java
│           │   ├── CodePuzzle.java
│           │   └── LogicPuzzle.java
│           ├── item/
│           │   ├── Item.java
│           │   └── Clue.java
│           └── door/
│               └── Door.java
└── README.md
```

## How to Run
From the project root:

```bash
cd EscapeRoom
javac -d out $(find src/main/java -name "*.java")
java -cp out main.Main
```

## Notes
This project is intentionally kept simple, readable, and easy to explain in a Java OOP viva.
