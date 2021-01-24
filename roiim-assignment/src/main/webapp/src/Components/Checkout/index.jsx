import { useState } from "react";
import styles from "./checkout.module.css";
import { Container, Label, Input, FormGroup, Button } from "reactstrap";
import { API_KEY_ENCODED } from "../../costants/constants";
import { api } from "../../apis/api";
import Loader from "react-loader-spinner";

const Checkout = ({
  totalAmount,
  setTotalAmount,
  setShowStore,
  loginEmail
}) => {
  const [userInfo, setUserInfo] = useState({ email: loginEmail });
  const [isLoading, setIsLoading] = useState(false);

  const setLoadingAnimation = async (loading) => {
    await new Promise(() => setIsLoading(loading));
  };

  const checkout = async (token, id) => {
    await window.paysafe.checkout.setup(
      API_KEY_ENCODED,
      {
        currency: "USD",
        amount: totalAmount * 100,
        locale: "en_US",
        singleUseCustomerToken: token,
        customerId: id,
        customer: {
          firstName: userInfo.firstName,
          lastName: userInfo.lastName,
          email: userInfo.email,
          phone: userInfo.phone,
          dateOfBirth: {
            day: 1,
            month: 7,
            year: 1990
          }
        },
        billingAddress: {
          nickName: "John Dee",
          street: "20735 Stevens Creek Blvd",
          street2: "Montessori",
          city: "Cupertino",
          zip: "95014",
          country: "US",
          state: "CA"
        },
        environment: "TEST",
        merchantRefNum:
          userInfo.email + Math.random().toString(36).substring(7),
        canEditAmount: false,

        displayPaymentMethods: ["card"],
        paymentMethodDetails: {
          paysafecard: {
            consumerId: id
          }
        }
      },
      (instance, error, result) => {
        if (result && result.paymentHandleToken) {
          result["merchantRefNum"] =
            userInfo.email + Math.random().toString(36).substring(7);
          result["currency"] = "USD";
          result["customerId"] = id;

          api
            .post("/payment", { ...result })
            .then((response) => {
              if (response.data.status === "COMPLETED") {
                instance.showSuccessScreen(response.data.paymentId);
                setTotalAmount(0);
              } else {
                instance.showFailureScreen("Payment failed");
                alert("Invalid card details");
              }
            })
            .catch((error) => {
              setLoadingAnimation(false);
              console.log(error.message);
              instance.showFailureScreen(error.correlationId);
            });
        } else {
          setLoadingAnimation(false);
          console.error(error);
          alert("Please try again, something went wrong");
        }
        setLoadingAnimation(false);
      },
      (stage, expired) => {
        switch (stage) {
          case "PAYMENT_HANDLE_NOT_CREATED": // Handle the scenario
          case "PAYMENT_HANDLE_CREATED": // Handle the scenario
          case "PAYMENT_HANDLE_REDIRECT": // Handle the scenario
          case "PAYMENT_HANDLE_PAYABLE": // Handle the scenario
          default: // Handle the scenario
        }
      }
    );
    setLoadingAnimation(false);
  };

  const getCustomer = async (body) => {
    try {
      const customerResponse = await api.post("/get-customer", {
        ...body
      });
      checkout(
        customerResponse.data.singleUseCustomerToken,
        customerResponse.data.customerId
      );
    } catch (err) {}
  };

  const makePayment = async (e) => {
    setLoadingAnimation(true);

    e.preventDefault();

    const body = {
      firstName: userInfo.firstName,
      lastName: userInfo.lastName,
      email: userInfo.email
    };

    await api
      .post("/create-customer", {
        ...body
      })
      .then(async (res) => {
        await getCustomer(res.data);
      })
      .catch((error) => {
        setLoadingAnimation(false);
        alert("Please try again, something went wrong");
        console.error(error);
      });
  };

  const handleChange = (event) => {
    setUserInfo({
      ...userInfo,
      [event.target.name]: event.target.value.trim()
    });
  };

  return (
    <>
      <div>
        <div
          className={styles.home}
          onClick={() => {
            setShowStore(true);
          }}
        >
          {"< Go to store"}
        </div>
        <Container className={styles.formGroup}>
          <FormGroup className={styles.formGroup}>
            <Label className={styles.label}>
              First Name<span className={styles.mandatory}> *</span>
            </Label>
            <Input
              className={styles.inputField}
              type="text"
              name="firstName"
              placeholder="ex. John"
              onChange={(e) => {
                handleChange(e);
              }}
            />
          </FormGroup>

          <FormGroup className={styles.formGroup}>
            <Label className={styles.label}>
              Last Name<span className={styles.mandatory}> *</span>
            </Label>
            <Input
              className={styles.inputField}
              type="text"
              name="lastName"
              placeholder="ex. Doe"
              onChange={(e) => {
                handleChange(e);
              }}
            />
          </FormGroup>

          <FormGroup className={styles.formGroup}>
            <Label className={styles.label}>
              Email<span className={styles.mandatory}> *</span>
            </Label>
            <Input
              className={styles.inputField}
              type="email"
              name="email"
              value={loginEmail}
              disabled
              placeholder="ex. abc@xyz.com"
              onChange={(e) => {
                handleChange(e);
              }}
            />
          </FormGroup>

          <FormGroup className={styles.formGroup}>
            <Label className={styles.label}>Phone</Label>
            <Input
              className={styles.inputField}
              type="phone"
              name="phone"
              placeholder="ex. 3192939213"
              onChange={(e) => {
                handleChange(e);
              }}
            />
          </FormGroup>

          <FormGroup className={styles.formGroup}>
            <Label className={styles.label}>Street</Label>
            <Input
              className={styles.inputField}
              type="text"
              name="street"
              placeholder="ex. 12-C"
              onChange={(e) => {
                handleChange(e);
              }}
            />
          </FormGroup>

          <FormGroup className={styles.formGroup}>
            <Label className={styles.label}>City</Label>
            <Input
              className={styles.inputField}
              type="text"
              name="city"
              placeholder="ex. New York City"
              onChange={(e) => {
                handleChange(e);
              }}
            />
          </FormGroup>

          <FormGroup className={styles.formGroup}>
            <Label className={styles.label}>State</Label>
            <Input
              className={styles.inputField}
              type="text"
              name="state"
              placeholder="ex. New York"
              onChange={(e) => {
                handleChange(e);
              }}
            />
          </FormGroup>

          <FormGroup className={styles.formGroup}>
            <Label className={styles.label}>Country</Label>
            <Input
              className={styles.inputField}
              type="text"
              name="country"
              placeholder="ex. USA"
              onChange={(e) => {
                handleChange(e);
              }}
            />
          </FormGroup>
          <FormGroup className={styles.formGroup}>
            <Label className={styles.label}>
              Total Amount : {totalAmount}${" "}
            </Label>
          </FormGroup>

          <FormGroup className={styles.formGroup}>
            <Button
              className={styles.payButton}
              onClick={(event) => {
                if (totalAmount === 0) {
                  if (
                    window.confirm("Cart is empty, Want to explore our store?")
                  ) {
                    setShowStore(true);
                  }
                  return;
                }
                if (!userInfo.firstName || userInfo.firstName.trim() === "") {
                  alert("First name can not be empty");
                  return;
                } else if (
                  !userInfo.lastName ||
                  userInfo.lastName.trim() === ""
                ) {
                  alert("Last name can not be empty");
                  return;
                }
                makePayment(event);
              }}
            >
              Pay
            </Button>

            {isLoading && (
              <div className={styles.spinner}>
                <Loader type="Puff" color="#a569bd" height={30} width={30} />
              </div>
            )}
          </FormGroup>
        </Container>
      </div>
    </>
  );
};
export default Checkout;
