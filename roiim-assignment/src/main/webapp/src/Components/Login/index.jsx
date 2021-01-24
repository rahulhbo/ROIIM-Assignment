import { Input, FormGroup, Label, Button } from "reactstrap";
import styles from "./login.module.css";

import { useState } from "react";
import Loader from "react-loader-spinner";

const Login = ({ loginEmail, setLoginEmail, setIsLoggedIn }) => {
  const [isLoading, setIsLoading] = useState(false);

  const validateEmail = (email) => {
    const re = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(String(email).toLowerCase());
  };

  const setLoadingAnimation = async (loading) => {
    await new Promise(() => setIsLoading(loading));
  };

  const checkCustomerAvailability = () => {
    if (loginEmail === "" || loginEmail === null) {
      alert("Unique email id can not be empty");
      setLoadingAnimation(false);
      return;
    }

    setIsLoggedIn(true);
  };

  return (
    <div className={styles.loginWrapper}>
      <div>
        <h1 className={styles.heading}>Login to Account</h1>

        <div>
          <FormGroup className={styles.formGroup}>
            <Label className={styles.label}>Enter email ID</Label>
            <Input
              className={styles.inputField}
              type="text"
              name="city"
              placeholder="ex. abc@abc.example.com"
              onChange={(e) => {
                setLoginEmail(e.target.value);
              }}
            />
          </FormGroup>

          <div className={styles.checkButtonWrapper}>
            <FormGroup className={styles.formGroup}>
              <Button
                className={styles.createAccountButton}
                onClick={(event) => {
                  setLoadingAnimation(true);
                  if (validateEmail(loginEmail)) {
                    checkCustomerAvailability(event);
                  } else {
                    alert("Enter valid email");
                    setLoadingAnimation(false);
                  }
                }}
              >
                Login
              </Button>
            </FormGroup>
            {isLoading && (
              <Loader type="Puff" color="#a569bd" height={30} width={30} />
            )}
          </div>
        </div>
      </div>
    </div>
  );
};

export default Login;
