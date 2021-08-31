package com.example.channelicon

import android.animation.Animator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.channelicon.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.buttonDown.setOnClickListener {

            binding.imageView1.animate().apply {
                duration = 400
                translationY(230f)
                alpha(.2f)
            }

            binding.imageView2.animate().apply {
                duration = 400
                alpha(0f)
            }
            binding.imageView3.animate().apply {
                duration = 400
                translationY(230f)
                alpha(1f)
                setListener(object:Animator.AnimatorListener{
                    override fun onAnimationStart(animation: Animator?) {

                    }

                    override fun onAnimationEnd(animation: Animator?) {
                        val temp = binding.imageView1.drawable
                        binding.imageView1.apply {
                            translationY=0f
                            alpha = 1f
                            setImageDrawable(binding.imageView3.drawable)

                        }
                        binding.imageView3.apply {
                            translationY=0f
                            alpha = 0.2f
                            setImageDrawable(binding.imageView2.drawable)

                        }

                        binding.imageView2.apply {
                            translationY=0f
                            alpha = 0.2f
                            setImageDrawable(temp)

                        }

                    }

                    override fun onAnimationCancel(animation: Animator?) {

                    }

                    override fun onAnimationRepeat(animation: Animator?) {

                    }
                })
            }

        }

        binding.buttonUp.setOnClickListener {
            binding.imageView1.animate().apply {
                duration = 400
                translationY(-230f)
                alpha(.2f)
            }

            binding.imageView2.animate().apply {
                duration = 400
                translationY(-230f)
                alpha(1f)
            }
            binding.imageView3.animate().apply {
                duration = 400
                alpha(0f)
                setListener(object:Animator.AnimatorListener{
                    override fun onAnimationStart(animation: Animator?) {

                    }

                    override fun onAnimationEnd(animation: Animator?) {
                        val temp = binding.imageView1.drawable
                        binding.imageView1.apply {
                            translationY=0f
                            alpha = 1f
                            setImageDrawable(binding.imageView2.drawable)

                        }

                        binding.imageView2.apply {
                            translationY=0f
                            alpha = 0.2f
                            setImageDrawable(binding.imageView3.drawable)

                        }
                        binding.imageView3.apply {
                            translationY=0f
                            alpha = 0.2f
                            setImageDrawable(temp)

                        }

                    }

                    override fun onAnimationCancel(animation: Animator?) {

                    }

                    override fun onAnimationRepeat(animation: Animator?) {

                    }
                })
            }
        }
    }
}