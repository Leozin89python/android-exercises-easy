package com.example.whattsap.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.multidex.MultiDex;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.whattsap.Config.ConfiguracaoFirebase;
import com.example.whattsap.Config.Usuario;
import com.example.whattsap.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText areaEmail, areaSenha;
    private FirebaseAuth autenticacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MultiDex.install(this);
        setContentView(R.layout.activity_main);

        autenticacao = ConfiguracaoFirebase.getFirebaseAutenticacao();
        areaEmail = findViewById(R.id.email);
        areaSenha = findViewById(R.id.senha);

    }

    public void logar(Usuario user)
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
                    Toast.makeText(MainActivity.this,
                            "Erro ao autenticar usuário!",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser UsuarioAtual = autenticacao.getCurrentUser();
        //Jamilton usou UsuarioAtual != null
        if(UsuarioAtual != null){   //!UsuarioAtual.equals() == se o usuário não(!) estiver vazio("") então chama-se o método
            abrirTelaPrincipal();
        }
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
                Toast.makeText(MainActivity.this,
                        "Preencha a senha",
                        Toast.LENGTH_SHORT).show();
            }
        }
        else
        {
            Toast.makeText(MainActivity.this,
                    "Preencha o e-mail!",
                    Toast.LENGTH_SHORT).show();
        }
    }


    public void abrirTela(View view)
    {
        Intent abertura = new Intent(MainActivity.this, Cadastro.class);
        startActivity(abertura);
    }
    public void abrirTelaPrincipal()
    {
        Intent abertura= new Intent(MainActivity.this, Login.class);
        startActivity(abertura);
    }

}




