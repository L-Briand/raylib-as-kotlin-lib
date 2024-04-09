package net

import kotlinx.cinterop.*
import raylib.*

@OptIn(ExperimentalForeignApi::class)
fun main() {

    InitWindow(800, 450, "raylib [core] example - basic window");
    while (!WindowShouldClose()) {
        BeginDrawing();
        ClearBackground(white.readValue());
        DrawText("Congrats! You created your first window!", 190, 200, 20, lightgray.readValue());
        EndDrawing();
    }

    CloseWindow();
}