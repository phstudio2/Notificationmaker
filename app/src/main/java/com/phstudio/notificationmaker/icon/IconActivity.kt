package com.phstudio.notificationmaker.icon

import android.annotation.SuppressLint
import android.app.*
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate.*
import com.phstudio.notificationmaker.MainActivity
import com.phstudio.notificationmaker.R.*
import com.phstudio.notificationmaker.R.drawable.*
import java.util.*
import kotlin.collections.ArrayList

class IconActivity : AppCompatActivity() {

    var icon = ic001

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_icon)
        val bundle = intent.extras
        val text = bundle!!.getString("size")
        val abouttext = findViewById<TextView>(id.abouttext)
        when (text) {
            "small" -> {
                abouttext.text = getString(string.selectsmall_icon)
            }
            "big" -> {
                abouttext.text = getString(string.selectbig_icon)
            }
        }


        val btDismiss = findViewById<Button>(id.cancel_button)
        btDismiss.setOnClickListener {
            this@IconActivity.startActivity(
                Intent(
                    this@IconActivity,
                    MainActivity::class.java
                )
            )
            overridePendingTransition(0, 0)

        }
        val select_category3 = findViewById<Spinner>(id.select_category)
        val social = findViewById<ScrollView>(id.scrollView2)
        val work = findViewById<ScrollView>(id.scrollView1)
        val lego = findViewById<ScrollView>(id.scrollView3)
        val emoji = findViewById<ScrollView>(id.scrollView4)
        val animals = findViewById<ScrollView>(id.scrollView5)
        val sport = findViewById<ScrollView>(id.scrollView6)

        val list3 = ArrayList<String>()
        list3.add(resources.getString(string.work))
        list3.add(resources.getString(string.social))
        list3.add(resources.getString(string.lego))
        list3.add(resources.getString(string.animals))
        list3.add(resources.getString(string.sport))
        list3.add(resources.getString(string.emoji))

        val adapter3 = ArrayAdapter(this, layout.layout_spinner, list3)
        adapter3.setDropDownViewResource(layout.layout_spinner)
        select_category3.adapter = adapter3
        select_category3.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long,
            ) {
                when (position) {
                    0 -> {
                        work.visibility = View.VISIBLE
                        social.visibility = View.GONE
                        lego.visibility = View.GONE
                        emoji.visibility = View.GONE
                        animals.visibility = View.GONE
                        sport.visibility = View.GONE
                    }
                    1 -> {
                        work.visibility = View.GONE
                        social.visibility = View.VISIBLE
                        lego.visibility = View.GONE
                        emoji.visibility = View.GONE
                        animals.visibility = View.GONE
                        sport.visibility = View.GONE
                    }
                    2 -> {
                        work.visibility = View.GONE
                        social.visibility = View.GONE
                        lego.visibility = View.VISIBLE
                        emoji.visibility = View.GONE
                        animals.visibility = View.GONE
                        sport.visibility = View.GONE
                    }
                    3 -> {
                        work.visibility = View.GONE
                        social.visibility = View.GONE
                        lego.visibility = View.GONE
                        emoji.visibility = View.VISIBLE
                        animals.visibility = View.GONE
                        sport.visibility = View.GONE
                    }
                    4 -> {
                        work.visibility = View.GONE
                        social.visibility = View.GONE
                        lego.visibility = View.GONE
                        emoji.visibility = View.GONE
                        animals.visibility = View.VISIBLE
                        sport.visibility = View.GONE
                    }
                    5 -> {
                        work.visibility = View.GONE
                        social.visibility = View.GONE
                        lego.visibility = View.GONE
                        emoji.visibility = View.GONE
                        animals.visibility = View.GONE
                        sport.visibility = View.VISIBLE
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }
        val social1 = findViewById<ImageButton>(id.social1)
        social1.setOnClickListener {
            icon = social001
            back()
        }
        val social2 = findViewById<ImageButton>(id.social2)
        social2.setOnClickListener {
            icon = social002
            back()
        }
        val social3 = findViewById<ImageButton>(id.social3)
        social3.setOnClickListener {
            icon = social003
            back()
        }
        val social4 = findViewById<ImageButton>(id.social4)
        social4.setOnClickListener {
            icon = social004
            back()
        }
        val social5 = findViewById<ImageButton>(id.social5)
        social5.setOnClickListener {
            icon = social005
            back()
        }
        val social6 = findViewById<ImageButton>(id.social6)
        social6.setOnClickListener {
            icon = social006
            back()
        }
        val social7 = findViewById<ImageButton>(id.social7)
        social7.setOnClickListener {
            icon = social007
            back()
        }
        val social8 = findViewById<ImageButton>(id.social8)
        social8.setOnClickListener {
            icon = social008
            back()
        }
        val social9 = findViewById<ImageButton>(id.social9)
        social9.setOnClickListener {
            icon = social009
            back()
        }
        val social10 = findViewById<ImageButton>(id.social10)
        social10.setOnClickListener {
            icon = social010
            back()
        }
        val social11 = findViewById<ImageButton>(id.social11)
        social11.setOnClickListener {
            icon = social011
            back()
        }
        val social12 = findViewById<ImageButton>(id.social12)
        social12.setOnClickListener {
            icon = social012
            back()
        }
        val social13 = findViewById<ImageButton>(id.social13)
        social13.setOnClickListener {
            icon = social013
            back()
        }
        val social14 = findViewById<ImageButton>(id.social14)
        social14.setOnClickListener {
            icon = social014
            back()
        }
        val social15 = findViewById<ImageButton>(id.social15)
        social15.setOnClickListener {
            icon = social015
            back()
        }
        val social16 = findViewById<ImageButton>(id.social16)
        social16.setOnClickListener {
            icon = social016
            back()
        }
        val social17 = findViewById<ImageButton>(id.social17)
        social17.setOnClickListener {
            icon = social017
            back()
        }
        val social18 = findViewById<ImageButton>(id.social18)
        social18.setOnClickListener {
            icon = social018
            back()
        }
        val social19 = findViewById<ImageButton>(id.social19)
        social19.setOnClickListener {
            icon = social019
            back()
        }
        val social20 = findViewById<ImageButton>(id.social20)
        social20.setOnClickListener {
            icon = social020
            back()
        }
        val social21 = findViewById<ImageButton>(id.social21)
        social21.setOnClickListener {
            icon = social021
            back()
        }
        val social22 = findViewById<ImageButton>(id.social22)
        social22.setOnClickListener {
            icon = social022
            back()
        }
        val social23 = findViewById<ImageButton>(id.social23)
        social23.setOnClickListener {
            icon = social023
            back()
        }
        val social24 = findViewById<ImageButton>(id.social24)
        social24.setOnClickListener {
            icon = social024
            back()
        }
        val social25 = findViewById<ImageButton>(id.social25)
        social25.setOnClickListener {
            icon = social025
            back()
        }
        val social26 = findViewById<ImageButton>(id.social26)
        social26.setOnClickListener {
            icon = social026
            back()
        }
        val social27 = findViewById<ImageButton>(id.social27)
        social27.setOnClickListener {
            icon = social027
            back()
        }
        val social28 = findViewById<ImageButton>(id.social28)
        social28.setOnClickListener {
            icon = social028
            back()
        }
        val social29 = findViewById<ImageButton>(id.social29)
        social29.setOnClickListener {
            icon = social029
            back()
        }
        val social30 = findViewById<ImageButton>(id.social30)
        social30.setOnClickListener {
            icon = social030
            back()
        }
        val icon1 = findViewById<ImageButton>(id.icon1)
        icon1.setOnClickListener {
            icon = ic001
            back()
        }
        val icon2 = findViewById<ImageButton>(id.icon2)
        icon2.setOnClickListener {
            icon = ic002
            back()
        }
        val icon3 = findViewById<ImageButton>(id.icon3)
        icon3.setOnClickListener {
            icon = ic003
            back()
        }
        val icon4 = findViewById<ImageButton>(id.icon4)
        icon4.setOnClickListener {
            icon = ic004
            back()
        }
        val icon5 = findViewById<ImageButton>(id.icon5)
        icon5.setOnClickListener {
            icon = ic005
            back()
        }
        val icon6 = findViewById<ImageButton>(id.icon6)
        icon6.setOnClickListener {
            icon = ic006
            back()
        }
        val icon7 = findViewById<ImageButton>(id.icon7)
        icon7.setOnClickListener {
            icon = ic007
            back()
        }
        val icon8 = findViewById<ImageButton>(id.icon8)
        icon8.setOnClickListener {
            icon = ic008
            back()
        }
        val icon9 = findViewById<ImageButton>(id.icon9)
        icon9.setOnClickListener {
            icon = ic009
            back()
        }
        val icon10 = findViewById<ImageButton>(id.icon10)
        icon10.setOnClickListener {
            icon = ic010
            back()
        }
        val icon11 = findViewById<ImageButton>(id.icon11)
        icon11.setOnClickListener {
            icon = ic011
            back()
        }
        val icon12 = findViewById<ImageButton>(id.icon12)
        icon12.setOnClickListener {
            icon = ic012
            back()
        }
        val icon13 = findViewById<ImageButton>(id.icon13)
        icon13.setOnClickListener {
            icon = ic013
            back()
        }
        val icon14 = findViewById<ImageButton>(id.icon14)
        icon14.setOnClickListener {
            icon = ic014
            back()
        }
        val icon15 = findViewById<ImageButton>(id.icon15)
        icon15.setOnClickListener {
            icon = ic015
            back()
        }
        val icon16 = findViewById<ImageButton>(id.icon16)
        icon16.setOnClickListener {
            icon = ic016
            back()
        }
        val icon17 = findViewById<ImageButton>(id.icon17)
        icon17.setOnClickListener {
            icon = ic017
            back()
        }
        val icon18 = findViewById<ImageButton>(id.icon18)
        icon18.setOnClickListener {
            icon = ic018
            back()
        }
        val icon19 = findViewById<ImageButton>(id.icon19)
        icon19.setOnClickListener {
            icon = ic019
            back()
        }
        val icon20 = findViewById<ImageButton>(id.icon20)
        icon20.setOnClickListener {
            icon = ic020
            back()
        }
        val icon21 = findViewById<ImageButton>(id.icon21)
        icon21.setOnClickListener {
            icon = ic021
            back()
        }
        val icon22 = findViewById<ImageButton>(id.icon22)
        icon22.setOnClickListener {
            icon = ic022
            back()
        }
        val icon23 = findViewById<ImageButton>(id.icon23)
        icon23.setOnClickListener {
            icon = ic023
            back()
        }
        val icon24 = findViewById<ImageButton>(id.icon24)
        icon24.setOnClickListener {
            icon = ic024
            back()
        }
        val icon25 = findViewById<ImageButton>(id.icon25)
        icon25.setOnClickListener {
            icon = ic025
            back()
        }
        val icon26 = findViewById<ImageButton>(id.icon26)
        icon26.setOnClickListener {
            icon = ic026
            back()
        }
        val icon27 = findViewById<ImageButton>(id.icon27)
        icon27.setOnClickListener {
            icon = ic027
            back()
        }
        val icon28 = findViewById<ImageButton>(id.icon28)
        icon28.setOnClickListener {
            icon = ic028
            back()
        }
        val icon29 = findViewById<ImageButton>(id.icon29)
        icon29.setOnClickListener {
            icon = ic029
            back()
        }
        val icon30 = findViewById<ImageButton>(id.icon30)
        icon30.setOnClickListener {
            icon = ic030
            back()
        }
        val icon31 = findViewById<ImageButton>(id.icon31)
        icon31.setOnClickListener {
            icon = ic031
            back()
        }
        val icon32 = findViewById<ImageButton>(id.icon32)
        icon32.setOnClickListener {
            icon = ic032
            back()
        }
        val icon33 = findViewById<ImageButton>(id.icon33)
        icon33.setOnClickListener {
            icon = ic033
            back()
        }
        val icon34 = findViewById<ImageButton>(id.icon34)
        icon34.setOnClickListener {
            icon = ic034
            back()
        }
        val icon35 = findViewById<ImageButton>(id.icon35)
        icon35.setOnClickListener {
            icon = ic035
            back()
        }
        val icon36 = findViewById<ImageButton>(id.icon36)
        icon36.setOnClickListener {
            icon = ic036
            back()
        }
        val lego1 = findViewById<ImageButton>(id.lego1)
        lego1.setOnClickListener {
            icon = lego001
            back()
        }
        val lego2 = findViewById<ImageButton>(id.lego2)
        lego2.setOnClickListener {
            icon = lego002
            back()
        }
        val lego3 = findViewById<ImageButton>(id.lego3)
        lego3.setOnClickListener {
            icon = lego003
            back()
        }
        val lego4 = findViewById<ImageButton>(id.lego4)
        lego4.setOnClickListener {
            icon = lego004
            back()
        }
        val lego5 = findViewById<ImageButton>(id.lego5)
        lego5.setOnClickListener {
            icon = lego005
            back()
        }
        val lego6 = findViewById<ImageButton>(id.lego6)
        lego6.setOnClickListener {
            icon = lego006
            back()
        }
        val lego7 = findViewById<ImageButton>(id.lego7)
        lego7.setOnClickListener {
            icon = lego007
            back()
        }
        val lego8 = findViewById<ImageButton>(id.lego8)
        lego8.setOnClickListener {
            icon = lego008
            back()
        }
        val lego9 = findViewById<ImageButton>(id.lego9)
        lego9.setOnClickListener {
            icon = lego009
            back()
        }
        val lego10 = findViewById<ImageButton>(id.lego10)
        lego10.setOnClickListener {
            icon = lego010
            back()
        }
        val lego11 = findViewById<ImageButton>(id.lego11)
        lego11.setOnClickListener {
            icon = lego011
            back()
        }
        val lego12 = findViewById<ImageButton>(id.lego12)
        lego12.setOnClickListener {
            icon = lego012
            back()
        }
        val lego13 = findViewById<ImageButton>(id.lego13)
        lego13.setOnClickListener {
            icon = lego013
            back()
        }
        val lego14 = findViewById<ImageButton>(id.lego14)
        lego14.setOnClickListener {
            icon = lego014
            back()
        }
        val lego15 = findViewById<ImageButton>(id.lego15)
        lego15.setOnClickListener {
            icon = lego015
            back()
        }
        val lego16 = findViewById<ImageButton>(id.lego16)
        lego16.setOnClickListener {
            icon = lego016
            back()
        }
        val lego17 = findViewById<ImageButton>(id.lego17)
        lego17.setOnClickListener {
            icon = lego017
            back()
        }
        val lego18 = findViewById<ImageButton>(id.lego18)
        lego18.setOnClickListener {
            icon = lego018
            back()
        }
        val lego19 = findViewById<ImageButton>(id.lego19)
        lego19.setOnClickListener {
            icon = lego019
            back()
        }
        val lego20 = findViewById<ImageButton>(id.lego20)
        lego20.setOnClickListener {
            icon = lego020
            back()
        }
        val lego21 = findViewById<ImageButton>(id.lego21)
        lego21.setOnClickListener {
            icon = lego021
            back()
        }
        val lego22 = findViewById<ImageButton>(id.lego22)
        lego22.setOnClickListener {
            icon = lego022
            back()
        }
        val lego23 = findViewById<ImageButton>(id.lego23)
        lego23.setOnClickListener {
            icon = lego023
            back()
        }
        val lego24 = findViewById<ImageButton>(id.lego24)
        lego24.setOnClickListener {
            icon = lego024
            back()
        }
        val lego25 = findViewById<ImageButton>(id.lego25)
        lego25.setOnClickListener {
            icon = lego025
            back()
        }
        val lego26 = findViewById<ImageButton>(id.lego26)
        lego26.setOnClickListener {
            icon = lego026
            back()
        }
        val lego27 = findViewById<ImageButton>(id.lego27)
        lego27.setOnClickListener {
            icon = lego027
            back()
        }
        val lego28 = findViewById<ImageButton>(id.lego28)
        lego28.setOnClickListener {
            icon = lego028
            back()
        }
        val lego29 = findViewById<ImageButton>(id.lego29)
        lego29.setOnClickListener {
            icon = lego029
            back()
        }
        val lego30 = findViewById<ImageButton>(id.lego30)
        lego30.setOnClickListener {
            icon = lego030
            back()
        }
        val lego31 = findViewById<ImageButton>(id.lego31)
        lego31.setOnClickListener {
            icon = lego031
            back()
        }
        val lego32 = findViewById<ImageButton>(id.lego32)
        lego32.setOnClickListener {
            icon = lego032
            back()
        }
        val lego33 = findViewById<ImageButton>(id.lego33)
        lego33.setOnClickListener {
            icon = lego033
            back()
        }
        val lego34 = findViewById<ImageButton>(id.lego34)
        lego34.setOnClickListener {
            icon = lego034
            back()
        }
        val lego35 = findViewById<ImageButton>(id.lego35)
        lego35.setOnClickListener {
            icon = lego035
            back()
        }
        val lego36 = findViewById<ImageButton>(id.lego36)
        lego36.setOnClickListener {
            icon = lego036
            back()
        }
        val emoji1 = findViewById<ImageButton>(id.emoji1)
        emoji1.setOnClickListener {
            icon = emoji001
            back()
        }
        val emoji2 = findViewById<ImageButton>(id.emoji2)
        emoji2.setOnClickListener {
            icon = emoji002
            back()
        }
        val emoji3 = findViewById<ImageButton>(id.emoji3)
        emoji3.setOnClickListener {
            icon = emoji003
            back()
        }
        val emoji4 = findViewById<ImageButton>(id.emoji4)
        emoji4.setOnClickListener {
            icon = emoji004
            back()
        }
        val emoji5 = findViewById<ImageButton>(id.emoji5)
        emoji5.setOnClickListener {
            icon = emoji005
            back()
        }
        val emoji6 = findViewById<ImageButton>(id.emoji6)
        emoji6.setOnClickListener {
            icon = emoji006
            back()
        }
        val emoji7 = findViewById<ImageButton>(id.emoji7)
        emoji7.setOnClickListener {
            icon = emoji007
            back()
        }
        val emoji8 = findViewById<ImageButton>(id.emoji8)
        emoji8.setOnClickListener {
            icon = emoji008
            back()
        }
        val emoji9 = findViewById<ImageButton>(id.emoji9)
        emoji9.setOnClickListener {
            icon = emoji009
            back()
        }
        val emoji10 = findViewById<ImageButton>(id.emoji10)
        emoji10.setOnClickListener {
            icon = emoji010
            back()
        }
        val emoji11 = findViewById<ImageButton>(id.emoji11)
        emoji11.setOnClickListener {
            icon = emoji011
            back()
        }
        val emoji12 = findViewById<ImageButton>(id.emoji12)
        emoji12.setOnClickListener {
            icon = emoji012
            back()
        }
        val emoji13 = findViewById<ImageButton>(id.emoji13)
        emoji13.setOnClickListener {
            icon = emoji013
            back()
        }
        val emoji14 = findViewById<ImageButton>(id.emoji14)
        emoji14.setOnClickListener {
            icon = emoji014
            back()
        }
        val emoji15 = findViewById<ImageButton>(id.emoji15)
        emoji15.setOnClickListener {
            icon = emoji015
            back()
        }
        val emoji16 = findViewById<ImageButton>(id.emoji16)
        emoji16.setOnClickListener {
            icon = emoji016
            back()
        }
        val emoji17 = findViewById<ImageButton>(id.emoji17)
        emoji17.setOnClickListener {
            icon = emoji017
            back()
        }
        val emoji18 = findViewById<ImageButton>(id.emoji18)
        emoji18.setOnClickListener {
            icon = emoji018
            back()
        }
        val emoji19 = findViewById<ImageButton>(id.emoji19)
        emoji19.setOnClickListener {
            icon = emoji019
            back()
        }
        val emoji20 = findViewById<ImageButton>(id.emoji20)
        emoji20.setOnClickListener {
            icon = emoji020
            back()
        }
        val emoji21 = findViewById<ImageButton>(id.emoji21)
        emoji21.setOnClickListener {
            icon = emoji021
            back()
        }
        val emoji22 = findViewById<ImageButton>(id.emoji22)
        emoji22.setOnClickListener {
            icon = emoji022
            back()
        }
        val emoji23 = findViewById<ImageButton>(id.emoji23)
        emoji23.setOnClickListener {
            icon = emoji023
            back()
        }
        val emoji24 = findViewById<ImageButton>(id.emoji24)
        emoji24.setOnClickListener {
            icon = emoji024
            back()
        }
        val emoji25 = findViewById<ImageButton>(id.emoji25)
        emoji25.setOnClickListener {
            icon = emoji025
            back()
        }
        val emoji26 = findViewById<ImageButton>(id.emoji26)
        emoji26.setOnClickListener {
            icon = emoji026
            back()
        }
        val emoji27 = findViewById<ImageButton>(id.emoji27)
        emoji27.setOnClickListener {
            icon = emoji027
            back()
        }
        val emoji28 = findViewById<ImageButton>(id.emoji28)
        emoji28.setOnClickListener {
            icon = emoji028
            back()
        }
        val emoji29 = findViewById<ImageButton>(id.emoji29)
        emoji29.setOnClickListener {
            icon = emoji029
            back()
        }
        val emoji30 = findViewById<ImageButton>(id.emoji30)
        emoji30.setOnClickListener {
            icon = emoji030
            back()
        }
        val emoji31 = findViewById<ImageButton>(id.emoji31)
        emoji31.setOnClickListener {
            icon = emoji031
            back()
        }
        val emoji32 = findViewById<ImageButton>(id.emoji32)
        emoji32.setOnClickListener {
            icon = emoji032
            back()
        }
        val emoji33 = findViewById<ImageButton>(id.emoji33)
        emoji33.setOnClickListener {
            icon = emoji033
            back()
        }
        val emoji34 = findViewById<ImageButton>(id.emoji34)
        emoji34.setOnClickListener {
            icon = emoji034
            back()
        }
        val emoji35 = findViewById<ImageButton>(id.emoji35)
        emoji35.setOnClickListener {
            icon = emoji035
            back()
        }
        val emoji36 = findViewById<ImageButton>(id.emoji36)
        emoji36.setOnClickListener {
            icon = emoji036
            back()
        }
        val animals1 = findViewById<ImageButton>(id.animals1)
        animals1.setOnClickListener {
            icon = animals001
            back()
        }
        val animals2 = findViewById<ImageButton>(id.animals2)
        animals2.setOnClickListener {
            icon = animals002
            back()
        }
        val animals3 = findViewById<ImageButton>(id.animals3)
        animals3.setOnClickListener {
            icon = animals003
            back()
        }
        val animals4 = findViewById<ImageButton>(id.animals4)
        animals4.setOnClickListener {
            icon = animals004
            back()
        }
        val animals5 = findViewById<ImageButton>(id.animals5)
        animals5.setOnClickListener {
            icon = animals005
            back()
        }
        val animals6 = findViewById<ImageButton>(id.animals6)
        animals6.setOnClickListener {
            icon = animals006
            back()
        }
        val animals7 = findViewById<ImageButton>(id.animals7)
        animals7.setOnClickListener {
            icon = animals007
            back()
        }
        val animals8 = findViewById<ImageButton>(id.animals8)
        animals8.setOnClickListener {
            icon = animals008
            back()
        }
        val animals9 = findViewById<ImageButton>(id.animals9)
        animals9.setOnClickListener {
            icon = animals009
            back()
        }
        val animals10 = findViewById<ImageButton>(id.animals10)
        animals10.setOnClickListener {
            icon = animals010
            back()
        }
        val animals11 = findViewById<ImageButton>(id.animals11)
        animals11.setOnClickListener {
            icon = animals011
            back()
        }
        val animals12 = findViewById<ImageButton>(id.animals12)
        animals12.setOnClickListener {
            icon = animals012
            back()
        }
        val animals13 = findViewById<ImageButton>(id.animals13)
        animals13.setOnClickListener {
            icon = animals013
            back()
        }
        val animals14 = findViewById<ImageButton>(id.animals14)
        animals14.setOnClickListener {
            icon = animals014
            back()
        }
        val animals15 = findViewById<ImageButton>(id.animals15)
        animals15.setOnClickListener {
            icon = animals015
            back()
        }
        val animals16 = findViewById<ImageButton>(id.animals16)
        animals16.setOnClickListener {
            icon = animals016
            back()
        }
        val animals17 = findViewById<ImageButton>(id.animals17)
        animals17.setOnClickListener {
            icon = animals017
            back()
        }
        val animals18 = findViewById<ImageButton>(id.animals18)
        animals18.setOnClickListener {
            icon = animals018
            back()
        }
        val animals19 = findViewById<ImageButton>(id.animals19)
        animals19.setOnClickListener {
            icon = animals019
            back()
        }
        val animals20 = findViewById<ImageButton>(id.animals20)
        animals20.setOnClickListener {
            icon = animals020
            back()
        }
        val animals21 = findViewById<ImageButton>(id.animals21)
        animals21.setOnClickListener {
            icon = animals021
            back()
        }
        val animals22 = findViewById<ImageButton>(id.animals22)
        animals22.setOnClickListener {
            icon = animals022
            back()
        }
        val animals23 = findViewById<ImageButton>(id.animals23)
        animals23.setOnClickListener {
            icon = animals023
            back()
        }
        val animals24 = findViewById<ImageButton>(id.animals24)
        animals24.setOnClickListener {
            icon = animals024
            back()
        }
        val animals25 = findViewById<ImageButton>(id.animals25)
        animals25.setOnClickListener {
            icon = animals025
            back()
        }
        val animals26 = findViewById<ImageButton>(id.animals26)
        animals26.setOnClickListener {
            icon = animals026
            back()
        }
        val animals27 = findViewById<ImageButton>(id.animals27)
        animals27.setOnClickListener {
            icon = animals027
            back()
        }
        val animals28 = findViewById<ImageButton>(id.animals28)
        animals28.setOnClickListener {
            icon = animals028
            back()
        }
        val animals29 = findViewById<ImageButton>(id.animals29)
        animals29.setOnClickListener {
            icon = animals029
            back()
        }
        val animals30 = findViewById<ImageButton>(id.animals30)
        animals30.setOnClickListener {
            icon = animals030
            back()
        }
        val animals31 = findViewById<ImageButton>(id.animals31)
        animals31.setOnClickListener {
            icon = animals031
            back()
        }
        val animals32 = findViewById<ImageButton>(id.animals32)
        animals32.setOnClickListener {
            icon = animals032
            back()
        }
        val animals33 = findViewById<ImageButton>(id.animals33)
        animals33.setOnClickListener {
            icon = animals033
            back()
        }
        val animals34 = findViewById<ImageButton>(id.animals34)
        animals34.setOnClickListener {
            icon = animals034
            back()
        }
        val animals35 = findViewById<ImageButton>(id.animals35)
        animals35.setOnClickListener {
            icon = animals035
            back()
        }
        val animals36 = findViewById<ImageButton>(id.animals36)
        animals36.setOnClickListener {
            icon = animals036
            back()
        }
        val sport1 = findViewById<ImageButton>(id.sport1)
        sport1.setOnClickListener {
            icon = sport001
            back()
        }
        val sport2 = findViewById<ImageButton>(id.sport2)
        sport2.setOnClickListener {
            icon = sport002
            back()
        }
        val sport3 = findViewById<ImageButton>(id.sport3)
        sport3.setOnClickListener {
            icon = sport003
            back()
        }
        val sport4 = findViewById<ImageButton>(id.sport4)
        sport4.setOnClickListener {
            icon = sport004
            back()
        }
        val sport5 = findViewById<ImageButton>(id.sport5)
        sport5.setOnClickListener {
            icon = sport005
            back()
        }
        val sport6 = findViewById<ImageButton>(id.sport6)
        sport6.setOnClickListener {
            icon = sport006
            back()
        }
        val sport7 = findViewById<ImageButton>(id.sport7)
        sport7.setOnClickListener {
            icon = sport007
            back()
        }
        val sport8 = findViewById<ImageButton>(id.sport8)
        sport8.setOnClickListener {
            icon = sport008
            back()
        }
        val sport9 = findViewById<ImageButton>(id.sport9)
        sport9.setOnClickListener {
            icon = sport009
            back()
        }
        val sport10 = findViewById<ImageButton>(id.sport10)
        sport10.setOnClickListener {
            icon = sport010
            back()
        }
        val sport11 = findViewById<ImageButton>(id.sport11)
        sport11.setOnClickListener {
            icon = sport011
            back()
        }
        val sport12 = findViewById<ImageButton>(id.sport12)
        sport12.setOnClickListener {
            icon = sport012
            back()
        }
        val sport13 = findViewById<ImageButton>(id.sport13)
        sport13.setOnClickListener {
            icon = sport013
            back()
        }
        val sport14 = findViewById<ImageButton>(id.sport14)
        sport14.setOnClickListener {
            icon = sport014
            back()
        }
        val sport15 = findViewById<ImageButton>(id.sport15)
        sport15.setOnClickListener {
            icon = sport015
            back()
        }
        val sport16 = findViewById<ImageButton>(id.sport16)
        sport16.setOnClickListener {
            icon = sport016
            back()
        }
        val sport17 = findViewById<ImageButton>(id.sport17)
        sport17.setOnClickListener {
            icon = sport017
            back()
        }
        val sport18 = findViewById<ImageButton>(id.sport18)
        sport18.setOnClickListener {
            icon = sport018
            back()
        }
        val sport19 = findViewById<ImageButton>(id.sport19)
        sport19.setOnClickListener {
            icon = sport019
            back()
        }
        val sport20 = findViewById<ImageButton>(id.sport20)
        sport20.setOnClickListener {
            icon = sport020
            back()
        }
        val sport21 = findViewById<ImageButton>(id.sport21)
        sport21.setOnClickListener {
            icon = sport021
            back()
        }
        val sport22 = findViewById<ImageButton>(id.sport22)
        sport22.setOnClickListener {
            icon = sport022
            back()
        }
        val sport23 = findViewById<ImageButton>(id.sport23)
        sport23.setOnClickListener {
            icon = sport023
            back()
        }
        val sport24 = findViewById<ImageButton>(id.sport24)
        sport24.setOnClickListener {
            icon = sport024
            back()
        }
        val sport25 = findViewById<ImageButton>(id.sport25)
        sport25.setOnClickListener {
            icon = sport025
            back()
        }
        val sport26 = findViewById<ImageButton>(id.sport26)
        sport26.setOnClickListener {
            icon = sport026
            back()
        }
        val sport27 = findViewById<ImageButton>(id.sport27)
        sport27.setOnClickListener {
            icon = sport027
            back()
        }
        val sport28 = findViewById<ImageButton>(id.sport28)
        sport28.setOnClickListener {
            icon = sport028
            back()
        }
        val sport29 = findViewById<ImageButton>(id.sport29)
        sport29.setOnClickListener {
            icon = sport029
            back()
        }
        val sport30 = findViewById<ImageButton>(id.sport30)
        sport30.setOnClickListener {
            icon = sport030
            back()
        }
        val sport31 = findViewById<ImageButton>(id.sport31)
        sport31.setOnClickListener {
            icon = sport031
            back()
        }
        val sport32 = findViewById<ImageButton>(id.sport32)
        sport32.setOnClickListener {
            icon = sport032
            back()
        }
        val sport33 = findViewById<ImageButton>(id.sport33)
        sport33.setOnClickListener {
            icon = sport033
            back()
        }
        val sport34 = findViewById<ImageButton>(id.sport34)
        sport34.setOnClickListener {
            icon = sport034
            back()
        }
        val sport35 = findViewById<ImageButton>(id.sport35)
        sport35.setOnClickListener {
            icon = sport035
            back()
        }
        val sport36 = findViewById<ImageButton>(id.sport36)
        sport36.setOnClickListener {
            icon = sport036
            back()
        }

    }

    @SuppressLint("CommitPrefEdits")
    private fun back() {
        this@IconActivity.startActivity(
            Intent(
                this@IconActivity,
                MainActivity::class.java
            )
        )
        overridePendingTransition(0, 0)
        val editor = getSharedPreferences(
            resources.getString(string.app_package),
            Context.MODE_PRIVATE
        ).edit()

        val bundle = intent.extras
        val text = bundle!!.getString("size")
        when (text) {
            "small" -> {
                editor.putInt("small", icon).apply()
            }
            "big" -> {
                editor.putInt("big", icon).apply()
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        this@IconActivity.startActivity(
            Intent(
                this@IconActivity,
                MainActivity::class.java
            )
        )
        overridePendingTransition(0, 0)
    }
}