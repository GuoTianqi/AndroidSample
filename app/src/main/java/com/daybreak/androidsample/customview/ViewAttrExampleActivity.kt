package com.daybreak.androidsample.customview

import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import butterknife.BindView
import butterknife.ButterKnife
import com.daybreak.androidsample.BaseToolBarActivity

import com.daybreak.androidsample.R

class ViewAttrExampleActivity : BaseToolBarActivity() {
    private lateinit var mEditText: EditText
    private lateinit var mImageView: ImageView
    private lateinit var mButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentLayout(R.layout.activity_view_attr_example)

        title = "ViewAttrExample"

        mButton = findViewById(R.id.button)
        mEditText = findViewById<EditText>(R.id.editText)
        mImageView = findViewById(R.id.imageView)

        mEditText.setText("减肥我姐夫owejfweljflkwej\n" +
                "麻烦了就无法理解为ljfwejfelwjfjweljjflewjjlekwj " +
                "解放了忘记了房价未来警方扣留为揭开了房价为刻录机风口浪尖为考虑房价未来科技飞机立刻我姐夫了\n" +
                "jlfkewlkj\n" +
                "jflejwl \n" +
                "解放了忘记\n" +
                "jflkewjl\n" +
                "减肥我姐夫owejfweljflkwej\n" +
                "麻烦了就无法理解为ljfwejfelwjfjweljjflewjjlekwj " +
                "解放了忘记了房价未来警方扣留为揭开了房价为刻录机风口浪尖为考虑房价未来科技飞机立刻我姐夫了\n" +
                "jlfkewlkj\n" +
                "jflejwl \n" +
                "解放了忘记\n" +
                "jflkewjl\n" +
                "减肥我姐夫owejfweljflkwej\n" +
                "麻烦了就无法理解为ljfwejfelwjfjweljjflewjjlekwj " +
                "解放了忘记了房价未来警方扣留为揭开了房价为刻录机风口浪尖为考虑房价未来科技飞机立刻我姐夫了\n" +
                "jlfkewlkj\n" +
                "jflejwl \n" +
                "解放了忘记\n" +
                "jflkewjl\n" +
                "减肥我姐夫owejfweljflkwej\n" +
                "麻烦了就无法理解为ljfwejfelwjfjweljjflewjjlekwj " +
                "解放了忘记了房价未来警方扣留为揭开了房价为刻录机风口浪尖为考虑房价未来科技飞机立刻我姐夫了\n" +
                "jlfkewlkj\n" +
                "jflejwl \n" +
                "解放了忘记\n" +
                "jflkewjl\n" +
                "减肥我姐夫owejfweljflkwej\n" +
                "麻烦了就无法理解为ljfwejfelwjfjweljjflewjjlekwj " +
                "解放了忘记了房价未来警方扣留为揭开了房价为刻录机风口浪尖为考虑房价未来科技飞机立刻我姐夫了\n" +
                "jlfkewlkj\n" +
                "jflejwl \n" +
                "解放了忘记\n" +
                "jflkewjl\n")

        mButton.setOnClickListener {
            val global = Rect()
            mImageView.getGlobalVisibleRect(global);
            val local = Rect()
            mImageView.getLocalVisibleRect(local);
            Toast.makeText(ViewAttrExampleActivity@this, "global=$global, local=$local",
                    Toast.LENGTH_LONG).show()
        }
    }
}
