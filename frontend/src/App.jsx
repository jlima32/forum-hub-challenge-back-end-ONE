import './App.css'
import FooterComponent from './components/FooterComponent'
import HeaderComponent from './components/HeaderComponent'
import ListTopicComponent from './components/ListTopicComponent'
import { BrowserRouter, Routes, Route  } from 'react-router-dom'
import TopicComponent from './components/TopicComponent'

function App() {

  return (
    <>
      <BrowserRouter>
        <HeaderComponent />
          <Routes>
            <Route path='/' element={ <ListTopicComponent /> } ></Route>
            <Route path='/add-topic' element={ <TopicComponent /> }></Route>
          </Routes>
        <FooterComponent />
      </BrowserRouter>
    </>
  )
}

export default App
