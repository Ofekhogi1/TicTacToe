package com.tictactoe

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.tictactoe.databinding.ActivityMainBinding
import com.tictactoe.model.Player
import com.tictactoe.model.TicTacToeGame

/**
 * Controller class (MainActivity) following MVC pattern
 * Handles user interactions and updates the view based on model state
 */
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val game = TicTacToeGame()
    private lateinit var boardButtons: List<Button>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initializeBoardButtons()
        setupClickListeners()
        updateUI()
    }

    /**
     * Initialize the list of board buttons
     */
    private fun initializeBoardButtons() {
        boardButtons = listOf(
            binding.btn0,
            binding.btn1,
            binding.btn2,
            binding.btn3,
            binding.btn4,
            binding.btn5,
            binding.btn6,
            binding.btn7,
            binding.btn8
        )
    }

    /**
     * Set up click listeners for all buttons
     */
    private fun setupClickListeners() {
        // Board buttons
        boardButtons.forEachIndexed { index, button ->
            button.setOnClickListener {
                onCellClicked(index)
            }
        }

        // Play Again button
        binding.btnPlayAgain.setOnClickListener {
            onPlayAgainClicked()
        }
    }

    /**
     * Handle cell click
     * @param position Position of the clicked cell (0-8)
     */
    private fun onCellClicked(position: Int) {
        if (game.makeMove(position)) {
            updateUI()
        }
    }

    /**
     * Handle Play Again button click
     */
    private fun onPlayAgainClicked() {
        game.resetGame()
        updateUI()
    }

    /**
     * Update the entire UI based on game state
     * This is the main method that synchronizes the view with the model
     */
    private fun updateUI() {
        updateBoard()
        updateStatus()
        updateScores()
        updatePlayAgainButton()
    }

    /**
     * Update all board buttons to reflect current game state
     */
    private fun updateBoard() {
        boardButtons.forEachIndexed { index, button ->
            val player = game.getPlayerAt(index)
            button.text = when (player) {
                Player.X -> "X"
                Player.O -> "O"
                Player.NONE -> ""
            }

            // Set text color based on player
            when (player) {
                Player.X -> button.setTextColor(
                    ContextCompat.getColor(this, R.color.player_x_color)
                )
                Player.O -> button.setTextColor(
                    ContextCompat.getColor(this, R.color.player_o_color)
                )
                Player.NONE -> {}
            }

            // Disable button if game is over
            button.isEnabled = !game.isGameOver()
        }
    }

    /**
     * Update status message
     */
    private fun updateStatus() {
        binding.tvStatus.text = when {
            game.isGameOver() && game.isDraw() -> getString(R.string.game_draw)
            game.isGameOver() && game.getWinner() == Player.X -> getString(R.string.player_x_wins)
            game.isGameOver() && game.getWinner() == Player.O -> getString(R.string.player_o_wins)
            game.getCurrentPlayer() == Player.X -> getString(R.string.player_x_turn)
            else -> getString(R.string.player_o_turn)
        }

        // Change status color based on game state
        binding.tvStatus.setTextColor(
            when {
                game.isGameOver() && game.getWinner() == Player.X ->
                    ContextCompat.getColor(this, R.color.player_x_color)
                game.isGameOver() && game.getWinner() == Player.O ->
                    ContextCompat.getColor(this, R.color.player_o_color)
                game.getCurrentPlayer() == Player.X ->
                    ContextCompat.getColor(this, R.color.player_x_color)
                else ->
                    ContextCompat.getColor(this, R.color.player_o_color)
            }
        )
    }

    /**
     * Update score display
     */
    private fun updateScores() {
        val (xScore, oScore) = game.getScores()
        binding.tvPlayerXScore.text = getString(R.string.player_x_score, xScore)
        binding.tvPlayerOScore.text = getString(R.string.player_o_score, oScore)
    }

    /**
     * Show or hide Play Again button based on game state
     */
    private fun updatePlayAgainButton() {
        binding.btnPlayAgain.visibility = if (game.isGameOver()) {
            View.VISIBLE
        } else {
            View.INVISIBLE
        }
    }
}
