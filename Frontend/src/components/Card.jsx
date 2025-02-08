/* From Uiverse.io by pamtbi */
import "./Component.css";
import PropTypes from "prop-types";

const Card = ({ isFlipped }) => {
  return (
    <div className={`card ${isFlipped ? "flipped" : ""}`}>
      <div className="card__side card__side_front">
        <div className="flex__1">
          <p className="card__side__name-bank">BANK</p>
          <div className="card__side__chip" />
          <p className="card__side__name-person">FIRSTNAME LASTNAME</p>
        </div>
      </div>
      <div className="card__side card__side_back">
        <div className="card__side__black" />
        <p className="card__side__number">XXXX XXXX XXXX XXXX</p>
        <div className="flex__2">
          <p className="card__side__other-numbers card__side__other-numbers_1">XX/XX</p>
          <p className="card__side__other-numbers card__side__other-numbers_2">XXX</p>
          <div className="card__side__debit">debit</div>
        </div>
      </div>
    </div>
  );
};

Card.propTypes = {
    isFlipped: PropTypes.bool.isRequired,
};

export default Card;
