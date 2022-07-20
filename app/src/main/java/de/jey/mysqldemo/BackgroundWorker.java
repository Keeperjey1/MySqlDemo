package de.jey.mysqldemo;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class BackgroundWorker extends AsyncTask<String, Void, String> {
    Context context;
    AlertDialog dialog;
    BackgroundWorker(Context ctx) {
        context = ctx;
    }
    @Override
    protected String doInBackground(String... voids) {
        String result = "";
        String type = voids[0];

        String login_url = "http://10.0.2.2/buero/loginbuero.php";
        String reg_url = "http://10.0.2.2/buero/register.php";
        if (type.equals("login")) {
            try {
                String username = voids[1];
                String password = voids[2];

                URL url = new URL(login_url);
                HttpURLConnection http = (HttpURLConnection)url.openConnection();
                http.setRequestMethod("POST");
                http.setDoOutput(true);
                http.setDoInput(true);
                OutputStream os = http.getOutputStream();
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
                String data = URLEncoder.encode("username","UTF-8")+"="+URLEncoder.encode(username,"UTF-8")+"&"
                        +URLEncoder.encode("password", "UTF-8")+"="+URLEncoder.encode(password,"UTF-8");
                writer.write(data);
                writer.flush();
                writer.close();
                os.close();
                InputStream is = http.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(is,"iso-8859-1"));

                String line = "";
                while ((line = reader.readLine())!= null) {
                    result += line;
                }
                reader.close();
                is.close();
                http.disconnect();
                return result;
            } catch (MalformedURLException e) {
                result = e.getMessage();
            } catch (IOException e) {
                result = e.getMessage();
            }
        } else if (type.equals("register")) {
            try {
                String name = voids[1];
                String surname = voids[2];
                String age = voids[3];
                String username = voids[4];
                String password = voids[5];
                //System.out.println(voids[5]);
                URL url = new URL(reg_url);
                HttpURLConnection http = (HttpURLConnection)url.openConnection();
                http.setRequestMethod("POST");
                http.setDoOutput(true);
                http.setDoInput(true);
                OutputStream os = http.getOutputStream();
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
                String data = URLEncoder.encode("name","UTF-8")+"="+URLEncoder.encode(name,"UTF-8")+"&"
                        +URLEncoder.encode("surname", "UTF-8")+"="+URLEncoder.encode(surname,"UTF-8")+"&"
                        +URLEncoder.encode("age", "UTF-8")+"="+URLEncoder.encode(age,"UTF-8")+"&"
                        +URLEncoder.encode("username", "UTF-8")+"="+URLEncoder.encode(username,"UTF-8")+"&"
                        +URLEncoder.encode("password", "UTF-8")+"="+URLEncoder.encode(password,"UTF-8");

                writer.write(data);
                writer.flush();
                writer.close();
                os.close();
                InputStream is = http.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(is,"iso-8859-1"));


                String line = "";
                while ((line = reader.readLine())!= null) {
                    result += line;
                }
                reader.close();
                is.close();
                http.disconnect();
                return result;
            } catch (MalformedURLException e) {
                result = e.getMessage();
            } catch (IOException e) {
                result = e.getMessage();
            }

        }
        return result;
    }

    @Override
    protected void onPreExecute() {
        dialog = new AlertDialog.Builder(context).create();
        dialog.setTitle("Login Status");
    }

    @Override
    protected void onPostExecute(String result) {
        dialog.setMessage(result);
        dialog.show();
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}
