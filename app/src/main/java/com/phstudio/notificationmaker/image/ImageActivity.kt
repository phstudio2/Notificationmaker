package com.phstudio.notificationmaker.image

import android.Manifest
import android.app.*
import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.os.Handler
import android.provider.MediaStore
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate.*
import com.phstudio.notificationmaker.MainActivity
import com.phstudio.notificationmaker.R.*
import com.phstudio.notificationmaker.R.drawable.*
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStream
import java.util.*

class ImageActivity : AppCompatActivity() {

    private var imageUri: Bitmap? = null
    private var outputUri: Uri? = null
    private val description = "Default"
    lateinit var text_title: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.layout_picture)

        val editor = getSharedPreferences(
            resources.getString(string.app_package),
            Context.MODE_PRIVATE
        ).edit()
        val sharedPreferences =
            getSharedPreferences(
                resources.getString(string.app_package),
                Context.MODE_PRIVATE
            )

        val imagepicture = sharedPreferences.getString("picture", "")

        val filenameandress = File(
            Environment.getExternalStorageDirectory().toString(),
            getString(string.app_name) + "/${imagepicture}.jpg"
        )
        imageUri = if (filenameandress.exists()) {
            val filename = (File(
                Environment.getExternalStorageDirectory().toString(),
                getString(string.app_name) + "/${imagepicture}.jpg"
            )).toString()
            val bitmap: Bitmap = BitmapFactory.decodeFile(filename)
            (bitmap)
        } else {
            BitmapFactory.decodeResource(resources, (pic001))
        }

        val btDismiss = findViewById<Button>(id.cancel_button)
        btDismiss.setOnClickListener {
            this@ImageActivity.startActivity(
                Intent(
                    this@ImageActivity,
                    MainActivity::class.java
                )
            )
            overridePendingTransition(0, 0)

        }
        val yourpic = findViewById<ImageView>(id.yourpic)
        yourpic.setImageBitmap(imageUri)

        val btn_from_galery = findViewById<Button>(id.btn_from_galery)
        btn_from_galery.setOnClickListener {
            checkPermissionONGallery(this)
        }

        val btn_from_camera = findViewById<Button>(id.btn_from_camera)
        btn_from_camera.setOnClickListener {
            checkPermissionONCamera()
        }

        val btn_default = findViewById<Button>(id.btn_default)
        btn_default.setOnClickListener {
            imageUri = BitmapFactory.decodeResource(resources, (pic001))
            editor.putString("picture", "null").apply()
        }
    }

    private fun checkPermissionONGallery(context: Context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
                val permission = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE)
                requestPermissions(permission, 1001)
                Handler().postDelayed({
                    checkPermissionONGallery(context)
                }, 1200)
            } else {
                pickImageFromGallery()
            }
        } else {
            Toast.makeText(context, context.getString(string.notsupport), Toast.LENGTH_SHORT).show()
        }
    }

    private fun pickImageFromGallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, 1000)
    }

    private fun checkPermissionONCamera() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_DENIED) {
                val permission = arrayOf(Manifest.permission.CAMERA)
                requestPermissions(permission, 1003)
                Handler().postDelayed({
                    checkPermissionONCamera()
                }, 1200)
            } else {
                if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
                    val permission2 = arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    requestPermissions(permission2, 1002)
                    Handler().postDelayed({
                        checkPermissionONCamera()
                    }, 1200)
                } else {
                    takePicture()
                }
            }
        } else {
            Toast.makeText(this, getString(string.notsupport), Toast.LENGTH_SHORT).show()
        }
    }


    private fun takePicture() {
        val folder_name =
            File(Environment.getExternalStorageDirectory().toString(), getString(string.app_name))
        if (!folder_name.exists()) {
            folder_name.mkdir()
        }
        val dirName: String = getString(string.app_name)
        val NamePIC: String = System.currentTimeMillis().toString()
        val resultPath = ("$folder_name/$NamePIC.jpg")
        val editor = getSharedPreferences(
            resources.getString(string.app_package),
            Context.MODE_PRIVATE
        ).edit()
        editor.putString("picture", NamePIC).apply()
        val values = ContentValues()
        if (Build.VERSION.SDK_INT < 29) {
            values.put(MediaStore.Images.Media.TITLE, NamePIC)
            values.put(MediaStore.Images.Media.DESCRIPTION, description)
            values.put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg")
            values.put(MediaStore.Images.Media.DATE_ADDED, System.currentTimeMillis())
            values.put("_data", resultPath)
            outputUri = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values)
        } else {
            val file = File(resultPath)
            val relativeLocation = Environment.DIRECTORY_PICTURES
            val contentValues = ContentValues()
            values.put(MediaStore.MediaColumns.RELATIVE_PATH, relativeLocation + dirName)
            values.put(MediaStore.MediaColumns.TITLE, NamePIC)
            values.put(MediaStore.MediaColumns.MIME_TYPE, "image/jpeg")
            values.put(MediaStore.MediaColumns.DATE_TAKEN, System.currentTimeMillis())
            values.put(MediaStore.MediaColumns.DATE_ADDED, System.currentTimeMillis())
            values.put(
                MediaStore.MediaColumns.BUCKET_ID,
                file.toString().lowercase(Locale.US).hashCode()
            )
            values.put(
                MediaStore.MediaColumns.BUCKET_DISPLAY_NAME,
                file.name.lowercase(Locale.US)
            )
            val resolver = contentResolver
            val contentUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            outputUri = resolver.insert(contentUri, contentValues)
        }
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        intent.putExtra(MediaStore.EXTRA_OUTPUT, outputUri)
        startActivityForResult(intent, 1005)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == 1000) {
            imageUri = MediaStore.Images.Media.getBitmap(this.contentResolver, data?.data)
            val yourpic = findViewById<ImageView>(id.yourpic)
            yourpic.setImageBitmap(imageUri)
            saveImage()
        } else if (resultCode == Activity.RESULT_OK && requestCode == 1005) {
            val transertoURI = MediaStore.Images.Media.getBitmap(contentResolver, outputUri)
            imageUri = transertoURI
            val yourpic = findViewById<ImageView>(id.yourpic)
            yourpic!!.setImageBitmap(imageUri)
        } else {
            Toast.makeText(this, getString(string.error), Toast.LENGTH_SHORT).show()
        }
    }

    private fun saveImage() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
                val permission = arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                requestPermissions(permission, 1004)
                Handler().postDelayed({
                    saveImage()
                }, 1200)
            } else {
                saveImageToStorage()
            }
        } else {
            Toast.makeText(this, getString(string.notsupport), Toast.LENGTH_SHORT).show()
        }
    }

    private fun saveImageToStorage() {
        val editor = getSharedPreferences(
            resources.getString(string.app_package),
            Context.MODE_PRIVATE
        ).edit()
        val folder_name =
            File(Environment.getExternalStorageDirectory().toString(), getString(string.app_name))
        if (!folder_name.exists()) {
            folder_name.mkdir()
        }
        val NamePIC: String = System.currentTimeMillis().toString()
        val nameoffile = ("$NamePIC.jpg")
        editor.putString("picture", NamePIC).apply()
        val file = File(folder_name, nameoffile)
        try {
            val stream: OutputStream = FileOutputStream(file)
            imageUri!!.compress(Bitmap.CompressFormat.JPEG, 100, stream)
            stream.flush()
            stream.close()
        } catch (e: Exception) {
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        this@ImageActivity.startActivity(
            Intent(
                this@ImageActivity,
                MainActivity::class.java
            )
        )
        overridePendingTransition(0, 0)
    }
}