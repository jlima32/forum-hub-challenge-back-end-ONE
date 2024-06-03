import React from 'react'

import './HeaderComponent.css'
import LoginComponent from './LoginComponent'

const HeaderComponent = () => {
  return (
        <header>
            <div className="logo">
                <h1><a href="#">Fórum<span>Hub</span></a></h1>
            </div>
            <LoginComponent />
        </header>
  )
}

export default HeaderComponent