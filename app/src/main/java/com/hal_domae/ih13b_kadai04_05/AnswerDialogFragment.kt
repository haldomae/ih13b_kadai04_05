package com.hal_domae.ih13b_kadai04_05

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class AnswerDialogFragment : DialogFragment() {
    // ダイアログを作る処理
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        // return super.onCreateDialog(savedInstanceState)
        // アクティビティがnull(存在しているか)をチェックする
        val dialog = activity?.let {
            MaterialAlertDialogBuilder(it)
                .setTitle(arguments?.getString("TITLE"))
                .setMessage(arguments?.getString("MESSAGE"))

                /*
                * Positive : 肯定的なアクション(OK、同意するなど)
                * Negative : 否定的なアクション(キャンセル、同意しないなど)
                * Neutral : どちらでも無い場合(保留、あとでなど)
                * */
                .setPositiveButton("OK") {_,_ ->
                    // OKを押したときに呼び出させるメソッドを指定
                    // MainActivityに記述した関数
                    (activity as MainActivity).checkQuizCount()
                }.create()
        }
        return dialog ?: throw IllegalStateException("アクティビティがnullです")
    }
}