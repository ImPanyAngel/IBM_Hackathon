import { useState } from 'react';
import Card from './Card';
import PropTypes from "prop-types";
import './Component.css';

import eyeShow from '../assets/eye-show.svg';
import eyeHide from '../assets/eye-hide.svg';
import addIcon from '../assets/add.svg';

function Account({money}) {
    const [isFlipped, setIsFlipped] = useState(false);
    const accountMoney = money;

    const handleToggleView = () => {
        setIsFlipped(prev => !prev);
    };

  return (
    <div className='account-container'>
        <Card isFlipped={isFlipped} />
        <div className='button-container-account'>
            <p className='money'>Account: £{accountMoney}</p>
            <button className='toggle-view' onClick={handleToggleView}>
                <img className='toggle-view-img' src={isFlipped ? eyeHide : eyeShow} alt="toggle view" />
            </button>
        </div>
    </div>
  );
}

Account.propTypes = {
    money: PropTypes.number.isRequired,
};

export default Account;
