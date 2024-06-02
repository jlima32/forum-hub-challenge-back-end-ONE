import React from 'react'

import './HeaderComponent.css'

const HeaderComponent = () => {
  return (
        <header>
            <div className="logo">
                <h1><a href="#">Fórum<span>Hub</span></a></h1>
            </div>
            <div className="user">
                <form action="">
                    <input type="email" placeholder='Email' required />
                    <input type="password" placeholder='Senha' required />
                    <button type="submit">Login</button>
                </form>
            </div>
        </header>
  )
}

export default HeaderComponent