package com.selim.anemitanisi.view

import android.app.AlertDialog
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.selim.anemitanisi.data.AnemiaDatabase
import com.selim.anemitanisi.databinding.FragmentHomeBinding
import com.selim.anemitanisi.model.AnemiaResult
import java.text.SimpleDateFormat
import java.util.*


class HomeFragment : Fragment() {

    private var db: AnemiaDatabase? = null
    private var binding: FragmentHomeBinding? = null
    private lateinit var sharedPref: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        db = AnemiaDatabase.getDatabase(requireContext())

        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding!!.lifecycleOwner = this
        sharedPref = requireActivity().getSharedPreferences("intro", Context.MODE_PRIVATE)
        binding!!.welcomeName.text = "Hoşgeldiniz " + sharedPref.getString("name", "DEFAULT_VALUE")
        binding!!.resultButton.setOnClickListener {
            if (binding!!.rbcValue.text.isNotEmpty() &&
                binding!!.hgbValue.text.isNotEmpty() &&
                binding!!.hctValue.text.isNotEmpty() &&
                binding!!.mcvValue.text.isNotEmpty() &&
                binding!!.mchValue.text.isNotEmpty() &&
                binding!!.mchcValue.text.isNotEmpty()
            ) {
                anemiaTest(
                    binding!!.rbcValue.text.toString().toDouble(),
                    binding!!.hgbValue.text.toString().toDouble(),
                    binding!!.hctValue.text.toString().toDouble(),
                    binding!!.mcvValue.text.toString().toDouble(),
                    binding!!.mchValue.text.toString().toDouble(),
                    binding!!.mchcValue.text.toString().toDouble(),
                )
            } else {
                val builder = AlertDialog.Builder(context)
                builder.setTitle("Uyarı !")
                builder.setMessage("Lütfen Tüm Değerleri Giriniz")
                builder.show()
            }

        }
        return binding!!.root
    }

    private fun anemiaTest(
        rbc: Double,
        hgb: Double,
        hct: Double,
        mcv: Double,
        mch: Double,
        mchc: Double
    ) {
        var testResult = ""
        if (hgb > 10.950) {
            if (hct <= 33.950) {
                if (mchc > 32.950) {
                    binding!!.testResult.text = "Hasta Değil"
                    testResult = "Hasta Değil"
                } else {
                    binding!!.testResult.text = "Hasta"
                    testResult = "Hasta"
                }
            } else {
                if (hgb > 11.350) {
                    if (rbc > 4.435) {
                        binding!!.testResult.text = "Hasta Değil"
                        testResult = "Hasta Değil"
                    } else {
                        if (rbc > 4.425) {
                            if (mchc > 32.650) {
                                binding!!.testResult.text = "Hasta Değil"
                                testResult = "Hasta Değil"
                            } else {
                                if (hgb > 12.45) {
                                    binding!!.testResult.text = "Hasta"
                                    testResult = "Hasta"
                                } else {
                                    binding!!.testResult.text = "Hasta Değil"
                                    testResult = "Hasta Değil"
                                }
                            }
                        } else {
                            binding!!.testResult.text = "Hasta Değil"
                            testResult = "Hasta Değil"
                        }
                    }
                } else {
                    if (mch > 29.950) {
                        if (rbc > 3.650) {
                            binding!!.testResult.text = "Hasta"
                            testResult = "Hasta"
                        } else {
                            binding!!.testResult.text = "Hasta Değil"
                            testResult = "Hasta Değil"
                        }
                    } else {
                        if (mchc > 31.350) {
                            binding!!.testResult.text = "Hasta Değil"
                            testResult = "Hasta Değil"
                        } else {
                            if (mchc > 31.10) {
                                binding!!.testResult.text = "Hasta"
                                testResult = "Hasta"
                            } else {
                                binding!!.testResult.text = "Hasta Değil"
                                testResult = "Hasta Değil"
                            }
                        }
                    }
                }
            }
        } else {
            binding!!.testResult.text = "Hasta"
            testResult = "Hasta"
        }
        val c = Calendar.getInstance()
        val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        val testDate: String = dateFormat.format(c.time)
        db?.anemiaDao()?.insertData(
            AnemiaResult(
                0,
                rbc,
                hgb,
                hct,
                mcv,
                mch,
                mchc,
                testResult,
                testDate
            )
        )
    }

}