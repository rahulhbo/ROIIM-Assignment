import styles from "./item.module.css";
import { Button } from "reactstrap";

const Item = ({ item, cart, setCart, totalAmount, setTotalAmount }) => {
  return (
    <>
      <div className={styles.itemWrapper}>
        <img
          src={`${process.env.PUBLIC_URL}/assets/images/${item.itemImage}`}
          alt=""
          className={styles.itemImage}
        />
        <div className={styles.itemInfoWrapper}>
          <label className={styles.itemInfo}>{item.itemName}</label>
          <label>{item.itemCategory}</label>
          <label className={styles.itemInfo}>{`Cost: ${item.itemCost}$`}</label>

          <Button
            className={styles.checkoutButton}
            onClick={() => {
              cart.push(item);
              setCart([...cart]);
              totalAmount += item.itemCost;
              setTotalAmount(totalAmount);
            }}
          >
            Add to cart
          </Button>
        </div>
      </div>
    </>
  );
};

export default Item;
