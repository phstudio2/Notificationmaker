package com.phstudio.notificationmaker.dialog

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.widget.*
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.phstudio.notificationmaker.R


class DialogActivity : Activity() {

    fun dialog(context: Context) {

        val inflater = LayoutInflater.from(context)
        val dialogView = inflater.inflate(R.layout.layout_dialog, null)
        val customDialog = AlertDialog.Builder(context)
            .setView(dialogView)
            .show()

        val tv_developer_name = dialogView.findViewById<TextView>(R.id.tv_developer_name)
        val tv_application_development =
            dialogView.findViewById<TextView>(R.id.tv_application_development)
        val tv_about = dialogView.findViewById<TextView>(R.id.tv_about)
        val tv_contact = dialogView.findViewById<TextView>(R.id.tv_contact)
        val tv_report_bug = dialogView.findViewById<TextView>(R.id.tv_report_bug)
        val tv_share = dialogView.findViewById<TextView>(R.id.tv_share)
        val tv_apps = dialogView.findViewById<TextView>(R.id.tv_apps)
        val tv_privacy = dialogView.findViewById<TextView>(R.id.tv_privacy)
        val tv_terms = dialogView.findViewById<TextView>(R.id.tv_terms)
        val tv_settings = dialogView.findViewById<TextView>(R.id.tv_settings)
        val fb_back = dialogView.findViewById<FloatingActionButton>(R.id.fb_back)

        fb_back.setOnClickListener {
            customDialog.dismiss()
        }

        tv_developer_name.setOnClickListener {
            Toast.makeText(
                context,
                context.getString(R.string.developer_name),
                Toast.LENGTH_SHORT
            )
                .show()
        }

        tv_application_development.setOnClickListener {
            Toast.makeText(
                context,
                context.getString(R.string.app_version),
                Toast.LENGTH_SHORT
            )
                .show()
        }

        tv_about.setOnClickListener {
            val browserIntent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse(context.getString(R.string.about))
            )
            context.startActivity(browserIntent)
        }

        tv_contact.setOnClickListener {
            val browserIntent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse(context.getString(R.string.contact))
            )
            context.startActivity(browserIntent)
        }

        tv_report_bug.setOnClickListener {
            val browserIntent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse(context.getString(R.string.report))
            )
            context.startActivity(browserIntent)
        }

        tv_share.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.putExtra(Intent.EXTRA_SUBJECT, context.resources.getString(R.string.share_mail))
            intent.putExtra(Intent.EXTRA_TEXT, (context.resources.getString(R.string.email_text) +"\n"+context.resources.getString(R.string.email_text2)+"\n"+context.resources.getString(R.string.email_text3)))
            intent.type = "message/rfc822"
            context.startActivity(Intent.createChooser(intent, context.resources.getString(R.string.select_email)))
        }

        tv_apps.setOnClickListener {
            val browserIntent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse(context.getString(R.string.googleplay))
            )
            context.startActivity(browserIntent)
        }

        tv_privacy.setOnClickListener {
            val browserIntent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse(context.getString(R.string.privacy))
            )
            context.startActivity(browserIntent)
        }

        tv_terms.setOnClickListener {
            val browserIntent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse(context.getString(R.string.terms))
            )
            context.startActivity(browserIntent)
        }

        tv_settings.setOnClickListener {
            val settingsclass: SettingsActivity by lazy {
                SettingsActivity()
            }
            settingsclass.settings(context)
        }
    }
}