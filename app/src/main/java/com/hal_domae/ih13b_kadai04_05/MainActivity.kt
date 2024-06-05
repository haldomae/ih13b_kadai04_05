package com.hal_domae.ih13b_kadai04_05

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.hal_domae.ih13b_kadai04_05.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    // ?を付ける事でnull許容型
    private var rightAnswer: String? = null // クイズの正解
    private var quizCount = 1 // 何問目か
    private val quizData = mutableListOf(
        listOf("膃肭臍", "おっとせい"),
        listOf("馴鹿", "となかい"),
        listOf("水豚", "かぴばら")
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        showNextQuiz()
    }

    // クイズを出題するメソッド
    private fun showNextQuiz(){
        // 問題番号を表示
//        val countLabel : TextView = findViewById(R.id.countLabel)
//        countLabel.text = "もんだい"
        binding.countLabel.text = getString(R.string.count_label, quizCount)

        // クイズの問題をセット
        val quiz = quizData[0]
        binding.questionLabel.text = quiz[0]
        // この問題の答え
        rightAnswer = quiz[1]

    }
}