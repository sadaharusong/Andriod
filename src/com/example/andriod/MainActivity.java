package com.example.andriod;

import java.util.Objects;

import android.R.anim;
import android.R.integer;
import android.support.v7.app.ActionBarActivity;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.RadioGroup;
import android.widget.ToggleButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class MainActivity extends ActionBarActivity implements OnCheckedChangeListener, android.widget.RadioGroup.OnCheckedChangeListener{
	private AutoCompleteTextView ac;
	private MultiAutoCompleteTextView mac;
	//��ʼ������Դ
	private String[] res = {"beijing1","beijing2","beijing3","shanghai1","shanghai2"};
	private String[] res2 = {"nanjing1","nanjing2","nanjing3","guiyang1","guiyang2"};
	//����
	private ToggleButton tb;
	private ImageView img;
	
	//checkbox
	private CheckBox cBox;
	
	//radio
	private RadioGroup rg;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//��ʼ���ؼ�
		ac = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView1);
		//��Ҫһ��������
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,res);
		//��adpter�뵱ǰAutoComeleteTextView��
		ac.setAdapter(adapter);
		
		mac = (MultiAutoCompleteTextView)findViewById(R.id.multiAutoCompleteTextView1);
		ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,res2);
		mac.setAdapter(adapter2);
		//���÷ָ���
		mac.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
		
		
		//����
		tb = (ToggleButton)findViewById(R.id.toggleButton1);
		img = (ImageView)findViewById(R.id.imageView1);
		
		//��������
		tb.setOnCheckedChangeListener(this);
		
		//checkbox
		cBox = (CheckBox)findViewById(R.id.checkBox1);
		//ͨ������checkbox�ļ����¼�����checkbox�ǲ��Ǳ�ѡ��
		cBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					//ͨ��onCheckedChanged��������ǰ��checkBox�Ƿ�ѡ��
				if(isChecked)
				{
					//���checkbox���ı�����
					String text = cBox.getText().toString();
					Log.i("tag",text);
				}
			}
		});
		
		//radio ʵ�ּ����¼�
		rg = (RadioGroup)findViewById(R.id.radioGroup1);
		rg.setOnCheckedChangeListener(this);
	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		// TODO Auto-generated method stub
		switch (checkedId) {
		case R.id.radio0:
			Log.i("tag","����һ��˧��");
			break;
		case R.id.radio1:
			Log.i("tag","����һ����˧��");
			break;
		default:
			break;
		}
	}

	
	@Override
	public void onCheckedChanged(CompoundButton buttonView,boolean isChecked)
	{
		/*��tb�������ʱ�򣬵�ǰ�ķ�����ִ��
			buttonView��������Ŀؼ�����
			isChecked��������Ŀؼ���״̬
			��������tb��ʱ�򣬸�������
			
		*/
		
		img.setBackgroundResource(isChecked?R.drawable.ic_launcher:R.drawable.abc_ab_solid_dark_holo);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}


	


}
