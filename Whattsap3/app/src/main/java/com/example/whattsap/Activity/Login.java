package com.example.whattsap.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentPagerAdapter;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.whattsap.Config.ConfiguracaoFirebase;
import com.example.whattsap.Config.Usuario;
import com.example.whattsap.Fragment.Contato;
import com.example.whattsap.Fragment.Conversa;
import com.example.whattsap.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItem;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentStatePagerItemAdapter;
import android.support.v4.app.
public class Login extends AppCompatActivity {

    /*private TextInputEditText areaEmail, areaSenha;
    private FirebaseAuth autenticacao;*/
    private FirebaseAuth autenticacao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        autenticacao = ConfiguracaoFirebase.getFirebaseAutenticacao();
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Whatsapp");
        setSupportActionBar(toolbar);

        /*autenticacao = ConfiguracaoFirebase.getFirebaseAutenticacao();
        areaEmail = findViewById(R.id.email);
        areaSenha = findViewById(R.id.senha);*/
        FragmentStatePagerItemAdapter adaptador = new FragmentPagerItemAdapter(
                getSupportFragmentManager(),
                FragmentPagerItems.with(this)
                .add("Conversas", Conversa.class)
                .add("Contatos", Contato.class)
                .create()
        );
    }

    @Override
    public boolean onCreatePanelMenu(int featureId, @NonNull Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        return super.onCreatePanelMenu(featureId, menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.menuSair:
                deslogarUser();
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
    public void deslogarUser()
    {
        try
        {
           autenticacao.signOut();
        }
        catch(Exception m) //(m) mistake
        {
           m.printStackTrace();
        }
    }
    /* public void logar(Usuario user)
    {
        autenticacao.signInWithEmailAndPassword(
                user.getEmail(), user.getSenha()
        ).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                  if(task.isSuccessful())
                  {
                     abrirTelaPrincipal();
                  }else
                  {
                      String excecao = ""; //exceção vazia
                      try
                      {
                          throw task.getException(); //recebe a exceção ou erro!
                      }
                      catch (FirebaseAuthWeakPasswordException e) //cada Cath trata um dos erros!
                      {
                          excecao = "Digite uma senha mais forte!";
                      }
                      catch (FirebaseAuthInvalidCredentialsException e)
                      {
                          excecao = "Por favor, digite um e-mail válido!";
                      }
                      catch (FirebaseAuthUserCollisionException e)
                      {
                          excecao = "Esta conta já foi cadastrada!";
                      }
                      catch (Exception e)
                      {
                          excecao = "Erro ao cadastrar usuário!" + e.getMessage();
                          e.printStackTrace();
                      }
                      Toast.makeText(Login.this,
                              "Erro ao autenticar usuário!",
                          Toast.LENGTH_SHORT).show();
                  }
            }
        });
    }

    public void validarUsuario(View view)
    {

        String captureEmail = areaEmail.getText().toString();
        String captureSenha = areaSenha.getText().toString();

            if(!captureEmail.isEmpty())//este verifica o email na mesma negação que a verificação de nome
            {
                if(!captureSenha.isEmpty())//este verifica a senha na mesma negação que a verificação de nome
                {
                    Usuario user = new Usuario(); //configuração completada de usuario
                    user.setEmail(captureEmail);
                    user.setSenha(captureSenha);

                    logar(user);
                }
                else
                {
                    Toast.makeText(Login.this,
                            "Preencha a senha",
                            Toast.LENGTH_SHORT).show();
                }
            }
            else
            {
                Toast.makeText(Login.this,
                        "Preencha o e-mail!",
                        Toast.LENGTH_SHORT).show();
            }
        }
    public void abrirTela(View view)
    {
        Intent abertura = new Intent(Login.this, Cadastro.class);
        startActivity(abertura);
    }
    public void abrirTelaPrincipal()
    {
        Intent abertura= new Intent(Login.this, MainActivity.class);
        startActivity(abertura);
    }*/



}
