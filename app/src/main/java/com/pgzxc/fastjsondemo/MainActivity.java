package com.pgzxc.fastjsondemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pgzxc.fastjsondemo.data.Constant;
import com.pgzxc.fastjsondemo.utils.ToastUtil;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setListener();
    }

    private void setListener() {
        findViewById(R.id.btn_strToObject).setOnClickListener(view->{
            JSONStrToJSONObject();
        });
        findViewById(R.id.btn_ObjToStr).setOnClickListener(view->{
            JSONObjectToJSONStr();
        });
        findViewById(R.id.btn_StrToArray).setOnClickListener(view->{
            JSONStrToJSONArray();
        });
        findViewById(R.id.btn_ArrayToStr).setOnClickListener(view->{
            JSONArrayToJSONStr();
        });
        findViewById(R.id.btn_ComplexToObj).setOnClickListener(view->{
            ComplexJSONStrToJSONObject();
        });
        findViewById(R.id.btn_ObjToComplex).setOnClickListener(view->{
            JSONObjectToComplexJSONStr();
        });
    }
    /**
     * json字符串-简单对象型到JSONObject的转换
     */
    public void JSONStrToJSONObject() {

        JSONObject jsonObject = JSONObject.parseObject(Constant.JSON_OBJ_STR);
        Log.e(TAG, "studentName:  " + jsonObject.getString("studentName") + ":" + "  studentAge:  "
                + jsonObject.getInteger("studentAge") );
        ToastUtil.show(this,"studentName:  " + jsonObject.getString("studentName") + ":" + "  studentAge:  "
                + jsonObject.getInteger("studentAge"));
    }
    /**
     * JSONObject到json字符串-简单对象型的转换
     */
    public void JSONObjectToJSONStr() {
        //已知JSONObject,目标要转换为json字符串
        JSONObject jsonObject = JSONObject.parseObject(Constant.JSON_OBJ_STR);
        // 第一种方式
        String jsonString = JSONObject.toJSONString(jsonObject);
        // 第二种方式
        //String jsonString = jsonObject.toJSONString();
        System.out.println(jsonString);
        ToastUtil.show(this,jsonString);
    }
    /**
     * json字符串-数组类型到JSONArray的转换
     */
    public void JSONStrToJSONArray(){

        JSONArray jsonArray = JSONArray.parseArray(Constant.JSON_ARRAY_STR);
        //遍历方式1
        int size = jsonArray.size();
        for (int i = 0; i < size; i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            System.out.println("studentName:  " + jsonObject.getString("studentName") + ":" + "  studentAge:  "
                    + jsonObject.getInteger("studentAge"));
        }
        //遍历方式2
        for (Object obj : jsonArray) {
            JSONObject jsonObject = (JSONObject) obj;
            Log.e(TAG, "studentName:  " + jsonObject.getString("studentName") + ":" + "  studentAge:  "
                    + jsonObject.getInteger("studentAge"));
        }
    }
    /**
     * JSONArray到json字符串-数组类型的转换
     */
    public void JSONArrayToJSONStr() {
        //已知JSONArray,目标要转换为json字符串
        JSONArray jsonArray = JSONArray.parseArray(Constant.JSON_ARRAY_STR);
        //第一种方式
        String jsonString = JSONArray.toJSONString(jsonArray);
        // 第二种方式
        //String jsonString = jsonArray.toJSONString(jsonArray);
        Log.e(TAG,jsonString);
    }
    /**
     * 复杂json格式字符串到JSONObject的转换
     */
    public void ComplexJSONStrToJSONObject() {

        JSONObject jsonObject = JSONObject.parseObject(Constant.COMPLEX_JSON_STR);
        String teacherName = jsonObject.getString("teacherName");
        Integer teacherAge = jsonObject.getInteger("teacherAge");
        Log.e(TAG,"teacherName:  " + teacherName + "   teacherAge:  " + teacherAge);
        JSONObject jsonObjectcourse = jsonObject.getJSONObject("course");
        //获取JSONObject中的数据
        String courseName = jsonObjectcourse.getString("courseName");
        Integer code = jsonObjectcourse.getInteger("code");
        Log.e(TAG,"courseName:  " + courseName + "   code:  " + code);
        JSONArray jsonArraystudents = jsonObject.getJSONArray("students");
        //遍历JSONArray
        for (Object object : jsonArraystudents) {
            JSONObject jsonObjectone = (JSONObject) object;
            String studentName = jsonObjectone.getString("studentName");
            Integer studentAge = jsonObjectone.getInteger("studentAge");
            Log.e(TAG,"studentName:  " + studentName + "   studentAge:  " + studentAge);
        }
    }

    /**
     * 复杂JSONObject到json格式字符串的转换
     */
    public void JSONObjectToComplexJSONStr() {
        //复杂JSONObject,目标要转换为json字符串
        JSONObject jsonObject = JSONObject.parseObject(Constant.COMPLEX_JSON_STR);
        //第一种方式
        //String jsonString = JSONObject.toJSONString(jsonObject);
        //第二种方式
        String jsonString = jsonObject.toJSONString();
        Log.e(TAG,jsonString);
    }
}
