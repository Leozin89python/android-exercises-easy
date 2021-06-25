package com.example.whattsap.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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

public class Cadastro extends AppCompatActivity {

    private TextInputEditText inserirNome, inserirEmail, inserirSenha ;
    private FirebaseAuth autenticacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        inserirNome = findViewById(R.id.loginNome);
        inserirEmail = findViewById(R.id.loginEmail);
        inserirSenha = findViewById(R.id.loginSenha);
    }

    public void cadastrarUsuario(Usuario user)
    {
        autenticacao = ConfiguracaoFirebase.getFirebaseAutenticacao();
        autenticacao.createUserWithEmailAndPassword(
                user.getEmail(),user.getSenha()
        ).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful())
                {
                    Toast.makeText(Cadastro.this, //este metodo gera mensagem ao usuário
                            "Sucesso ao cadastrar usuário",
                            Toast.LENGTH_SHORT).show();
                    finish();
                }
                else
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
                    Toast.makeText(Cadastro.this,//este metodo gera mensagem ao usuário
                            excecao,
                            Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    //metodo para cadastro de usuario
    public void validarUsuario(View view) {
        //recuperando os textos de email e senha
        String nome =  inserirNome.getText().toString();
        String email = inserirEmail.getText().toString();
        String senha = inserirSenha.getText().toString();
        //validação de email e senha

         //validação de email e senha
        if(!nome.isEmpty()) //a exclamação inverte o boolean se torna negação se 'torna o não esteja vazio'
             {
               if(!email.isEmpty())//este verifica o email na mesma negação que a verificação de nome
                    {
                     if(!senha.isEmpty())//este verifica a senha na mesma negação que a verificação de nome
                         {
                            Usuario user = new Usuario(); //configuração completada de usuario
  			                user.setNome(nome);
                            user.setEmail(email);
                            user.setSenha(senha);

                            cadastrarUsuario(user);
                         }
                     else
                         {
                             Toast.makeText(Cadastro.this,
                                     "Preencha a senha",
                                     Toast.LENGTH_SHORT).show();
                         }
                    }
               else
                    {
                        Toast.makeText(Cadastro.this,
                                "Preencha o e-mail!",
                                Toast.LENGTH_SHORT).show();
                    }
             }
        else
            {
             Toast.makeText(Cadastro.this,
                     "Preencha o nome!",
                     Toast.LENGTH_SHORT).show();
            }

    }
}









