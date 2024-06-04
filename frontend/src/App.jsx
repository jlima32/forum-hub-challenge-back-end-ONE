import './App.css'
import FooterComponent from './components/FooterComponent'
import HeaderComponent from './components/HeaderComponent'
import ListTopicComponent from './components/ListTopicComponent'
import { BrowserRouter, Routes, Route  } from 'react-router-dom'
import TopicComponent from './components/TopicComponent'
import TopicViewComponent from './components/TopicViewComponent'

function App() {

  return (
    <>
      <BrowserRouter>
        <HeaderComponent />
          <Routes>
            <Route path='/' element={ <ListTopicComponent /> } ></Route>
            <Route path='/add-topic' element={ <TopicComponent /> }></Route>
            <Route path='/update-topic/:id' element={ <TopicComponent /> }></Route>
            <Route path='/topic/:id' element={ <TopicViewComponent /> }></Route>
            <Route path='/topic/' element={ <ListTopicComponent /> }></Route>
          </Routes>
        <FooterComponent />
      </BrowserRouter>
    </>
  )
}

export default App
