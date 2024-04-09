package net

import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.cValue
import raylib.*

@OptIn(ExperimentalForeignApi::class)
fun main() {

    InitWindow(800, 450, "raylib [core] example - basic window");

    val white = cValue<Color> {
        r = 255u
        g = 255u
        b = 255u
        a = 255u
    }

    val lightGray = cValue<Color> {
        r = 255u
        a = 255u
    }

    while (!WindowShouldClose()) {
        BeginDrawing();
        ClearBackground(white);
        DrawText("Congrats! You created your first window!", 190, 200, 20, lightGray);
        EndDrawing();
    }

    CloseWindow();
}