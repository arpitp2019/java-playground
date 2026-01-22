# GameDemo - RPG Character Management System

A simple role-playing game character management system that allows players to create heroes, equip them with weapons, and assign companion pets for battle.

## Problem Statement

In role-playing games, players need a system to manage their characters effectively. The main challenges include:

- **Character Equipment Management**: Players want to equip their characters with different weapons (primary and secondary) and switch them during gameplay
- **Companion System**: Players need the ability to adopt and utilize companion pets that provide special abilities in combat
- **Shared Resources**: In multiplayer scenarios, multiple characters might need to share or trade the same equipment items
- **Inventory Tracking**: Players require a way to view their character's current status, equipped items, and health at any time
- **Combat Actions**: Characters need to perform attacks using their equipped weapons and call upon their companions for assistance

## Solution

GameDemo provides a character management system with the following capabilities:

- Create unique game characters with custom names
- Equip characters with primary and secondary weapons
- Assign companion pets with special abilities
- Execute combat actions (attacks, companion abilities)
- Track character health and equipment status
- Support equipment sharing between characters

## Features

- ✅ Create multiple game characters
- ✅ Equip weapons with different damage values
- ✅ Adopt companion pets with unique abilities
- ✅ Perform attacks that consume health/stamina
- ✅ Display real-time character status
- ✅ Share equipment between characters

## Project Structure

GameDemo/
├── Weapon.java # Weapon properties and behavior
├── Pet.java # Companion pet abilities
├── GameCharacter.java # Character management system
└── Main.java # Game simulation