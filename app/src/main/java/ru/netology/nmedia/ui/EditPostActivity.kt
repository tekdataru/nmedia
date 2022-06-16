package ru.netology.nmedia.ui

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import ru.netology.R
import ru.netology.databinding.ActivityEditPostBinding

class EditPostActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityEditPostBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with (binding) {
            buttonOk.setOnClickListener{
                if (text.text.isNullOrBlank()) {
                    Toast.makeText(
                        this@EditPostActivity,
                        getString(R.string.empty_text_error),
                        Toast.LENGTH_SHORT
                    ).show()
                    setResult(Activity.RESULT_CANCELED)
                    return@setOnClickListener
                } else {

                    setResult(
                        Activity.RESULT_OK,
                        Intent().putExtra(Intent.EXTRA_TEXT, text.text.toString())
                    )
                }

                finish()
            }
        }
    }
}