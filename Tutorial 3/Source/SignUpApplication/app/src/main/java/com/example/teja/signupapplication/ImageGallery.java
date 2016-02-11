package com.example.teja.signupapplication;

    import android.app.Activity;
    import android.content.Intent;
    import android.database.Cursor;
    import android.graphics.BitmapFactory;
    import android.net.Uri;
    import android.os.Bundle;
    import android.provider.MediaStore;
    import android.view.View;
    import android.widget.Button;
    import android.widget.ImageView;

    public class ImageGallery extends Activity {

        private static int RESULT_LOAD_IMAGE = 1;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            Button buttonLoadImage = (Button) findViewById(R.id.btn_gal);

            buttonLoadImage.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {

                    Intent i = new Intent(
                            Intent.ACTION_PICK,
                            android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                    startActivityForResult(i, RESULT_LOAD_IMAGE);
                }
            });
        }


        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);

            if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
                Uri selectedImage = data.getData();
                String[] filePathColumn = { MediaStore.Images.Media.DATA };

                Cursor cursor = getContentResolver().query(selectedImage,
                        filePathColumn, null, null, null);
                cursor.moveToFirst();

                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                String picturePath = cursor.getString(columnIndex);
                cursor.close();

                ImageView imageView = (ImageView) findViewById(R.id.view_photo);
                imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));

            }

        }
    }
