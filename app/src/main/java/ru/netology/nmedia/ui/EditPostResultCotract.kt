package ru.netology.nmedia.ui

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract
import ru.netology.nmedia.dto.Post

class EditPostResultCotract : ActivityResultContract<Post, String?>() {
    override fun createIntent(context: Context, input: Post): Intent =
        Intent(context, EditPostActivity::class.java)

    override fun parseResult(resultCode: Int, intent: Intent?): String? {
        if (resultCode == Activity.RESULT_OK){
            return  intent?.getStringExtra(Intent.EXTRA_TEXT)
        } else {
            return null
        }
    }


}