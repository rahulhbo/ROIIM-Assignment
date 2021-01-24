import { ITEMS } from "../../costants/items";
import Item from "../Item/";
import Checkout from "../Checkout/";
import styles from "./home.module.css";
import { useState } from "react";
import { FormGroup, Button } from "reactstrap";

import { useAlert } from "react-alert";

const Home = ({ loginEmail }) => {
  const [showStore, setShowStore] = useState(true);
  const [cart, setCart] = useState([]);
  const [totalAmount, setTotalAmount] = useState(0);
  const alert = useAlert();

  return (
    <>
      {!showStore ? (
        <Checkout
          setTotalAmount={setTotalAmount}
          totalAmount={totalAmount}
          loginEmail={loginEmail}
          setShowStore={setShowStore}
        />
      ) : (
        <div>
          <div className={styles.storeHeader}>
            <div className={styles.totalAmount}>
              Total Amount :<b> {totalAmount}$ </b>
            </div>
            <div>
              <FormGroup className={styles.formGroup}>
                <Button
                  className={styles.checkoutButton}
                  onClick={() => {
                    setShowStore(false);
                  }}
                >
                  Checkout
                </Button>
              </FormGroup>
            </div>
          </div>
          <div className={styles.itemsWrapper}>
            {ITEMS.map((item) => (
              <div
                key={item.itemId}
                onClick={() => alert.success("Item added to cart")}
              >
                <Item
                  item={item}
                  cart={cart}
                  setCart={setCart}
                  totalAmount={totalAmount}
                  setTotalAmount={setTotalAmount}
                />
              </div>
            ))}
          </div>
        </div>
      )}
    </>
  );
};
export default Home;
