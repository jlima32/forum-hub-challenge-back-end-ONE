import React, { useEffect, useState } from 'react'
import LoginService from '../services/LoginService'



const LoginComponent = () => {


  const [user, setUser] = useState(null);
  const[email, setEmail] = useState('');
  const[senha, setSenha] = useState('');
  const[loginOk, setLoginOk] = useState(false);

  useEffect(() => {
    const usuarioLogado = localStorage.getItem('user');
    if (usuarioLogado) {
      setUser(JSON.parse(usuarioLogado));
      setLoginOk(true);
    }
  }, [])

  const handleLogin = (e) => {
    e.preventDefault();
    LoginService.login(email, senha).then(
      
          (response) => {
            localStorage.setItem('user', JSON.stringify(response.data));
            setLoginOk(true);
            location.reload();
          },
          () => {
            alert('erro no login');
          }
        );
    
  }



  return (
    
    <div className="user">
        {loginOk ? ( <p>Olá, <span>{user.usuario.nome}</span></p>) 
        
        : 
        
        <form onSubmit={handleLogin}>
            <input type="email" placeholder='Email' value={email} onChange={(e) => setEmail(e.target.value)} required />
            <input type="password" placeholder='Senha' value={senha} onChange={(e) => setSenha(e.target.value)} required />
            <button type="submit">Login</button>
        </form>
        
        } 
        

    </div>
  )
}

export default LoginComponent