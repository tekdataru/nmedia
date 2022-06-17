package ru.netology.nmedia.ui

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract
import ru.netology.nmedia.dto.Post

class EditPostResultCotract : ActivityResultContract<Post, String?>() {
    override fun createIntent(context: Context, input: Post): Intent {
        val intent = Intent(context, EditPostActivity::class.java)

        intent.putExtra("postId", input.id)
        intent.putExtra("text", input.content)

        return intent
    }

    override fun parseResult(resultCode: Int, intent: Intent?): String? {
        if (resultCode == Activity.RESULT_OK){

            var stringResult = ""
            stringResult = intent?.getLongExtra("postId", 0).toString() + "<??!!!??>" +
                    intent?.getStringExtra(Intent.EXTRA_TEXT)


            return  stringResult
        } else {
            return null
        }
    }


}