package com.daybreak.androidsample.customview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import butterknife.BindView
import butterknife.ButterKnife
import com.daybreak.androidsample.BaseToolBarActivity

import com.daybreak.androidsample.R

class ViewAttrExampleActivity : BaseToolBarActivity() {
    lateinit var mEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentLayout(R.layout.activity_view_attr_example)

        title = "ViewAttrExample"

        mEditText = findViewById<EditText>(R.id.editText)

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
    }
}
