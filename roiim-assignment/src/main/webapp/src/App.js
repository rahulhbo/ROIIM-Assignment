import { useEffect, useState } from "react";
import Login from "./Components/Login/";
import Home from "./Components/Home/";
import { positions, Provider } from "react-alert";
import styles from "./app.module.css";
import {api} from "./apis/api";

const App = () => {

  //To awake Heroku server from sleep
  useEffect(()=>{
    api.get("/").then(async (response)=>{
      console.log("Server started");
    }).catch((error)=>{
      alert("Server not responding , please reload the page");
      console.error(error);
    })

  },[]);
  
  const [loginEmail, setLoginEmail] = useState(null);
  
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  const options = {
    timeout: 3000,
    position: positions.BOTTOM_RIGHT
  };

  const CustomAlertTemplate = ({ message }) => {
    return (
      <div className={styles.customAlert}>
        <div>
          <b>Success!!</b>
        </div>
        <div>{message}</div>
      </div>
    );
  };

  return (
    <div>
      {isLoggedIn ? (
        <Provider template={CustomAlertTemplate} {...options}>
          <Home loginEmail={loginEmail} />
        </Provider>
      ) : (
        <Login
          loginEmail={loginEmail}
          setLoginEmail={setLoginEmail}
          setIsLoggedIn={setIsLoggedIn}
        />
      )}
    </div>
  );
};

export default App;
