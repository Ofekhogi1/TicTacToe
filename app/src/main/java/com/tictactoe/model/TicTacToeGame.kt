package com.tictactoe.model

/**
 * Enum representing the players and empty cells in the game
 */
enum class Player {
    X, O, NONE
}

/**
 * Model class containing all game logic for Tic Tac Toe
 * Follows MVC pattern - contains no UI dependencies
 */
class TicTacToeGame {
    // 3x3 board represented as a single array (0-8)
    private val board = Array(9) { Player.NONE }

    // Current player's turn
    private var currentPlayer = Player.X

    // Score tracking
    private var xWins = 0
    private var oWins = 0

    // Game state
    private var gameOver = false
    private var winner: Player? = null

    /**
     * Make a move at the specified position
     * @param position Board position (0-8)
     * @return true if move was valid and made, false otherwise
     */
    fun makeMove(position: Int): Boolean {
        // Validate move
        if (position !in 0..8 || board[position] != Player.NONE || gameOver) {
            return false
        }

        // Place the move
        board[position] = currentPlayer

        // Check for winner
        if (checkWinCondition()) {
            gameOver = true
            winner = currentPlayer
            if (currentPlayer == Player.X) {
                xWins++
            } else {
                oWins++
            }
            return true
        }

        // Check for draw
        if (checkDrawCondition()) {
            gameOver = true
            winner = null
            return true
        }

        // Switch player
        currentPlayer = if (currentPlayer == Player.X) Player.O else Player.X
        return true
    }

    /**
     * Check if there's a winner
     * @return true if current player has won
     */
    private fun checkWinCondition(): Boolean {
        val winPatterns = arrayOf(
            // Rows
            intArrayOf(0, 1, 2),
            intArrayOf(3, 4, 5),
            intArrayOf(6, 7, 8),
            // Columns
            intArrayOf(0, 3, 6),
            intArrayOf(1, 4, 7),
            intArrayOf(2, 5, 8),
            // Diagonals
            intArrayOf(0, 4, 8),
            intArrayOf(2, 4, 6)
        )

        for (pattern in winPatterns) {
            if (board[pattern[0]] == currentPlayer &&
                board[pattern[1]] == currentPlayer &&
                board[pattern[2]] == currentPlayer
            ) {
                return true
            }
        }
        return false
    }

    /**
     * Check if the game is a draw (board full with no winner)
     * @return true if game is a draw
     */
    private fun checkDrawCondition(): Boolean {
        return board.all { it != Player.NONE }
    }

    /**
     * Get the current player
     * @return Current player (X or O)
     */
    fun getCurrentPlayer(): Player {
        return currentPlayer
    }

    /**
     * Get the winner of the game
     * @return Winner (X, O) or null if no winner/game not over
     */
    fun getWinner(): Player? {
        return winner
    }

    /**
     * Check if game is over
     * @return true if game has ended
     */
    fun isGameOver(): Boolean {
        return gameOver
    }

    /**
     * Check if game ended in a draw
     * @return true if game is a draw
     */
    fun isDraw(): Boolean {
        return gameOver && winner == null
    }

    /**
     * Get the player at a specific board position
     * @param position Board position (0-8)
     * @return Player at that position or NONE if empty
     */
    fun getPlayerAt(position: Int): Player {
        return if (position in 0..8) board[position] else Player.NONE
    }

    /**
     * Get the current scores for both players
     * @return Pair of (X wins, O wins)
     */
    fun getScores(): Pair<Int, Int> {
        return Pair(xWins, oWins)
    }

    /**
     * Reset the game board for a new game
     * Keeps the scores intact
     */
    fun resetGame() {
        for (i in board.indices) {
            board[i] = Player.NONE
        }
        currentPlayer = Player.X
        gameOver = false
        winner = null
    }

    /**
     * Reset everything including scores
     */
    fun resetAll() {
        resetGame()
        xWins = 0
        oWins = 0
    }
}
