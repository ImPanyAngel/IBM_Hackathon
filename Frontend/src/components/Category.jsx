import './Component.css';

function Category() {

  return (
    <div className='category-container'>
        <div className="header">
            <h1 className="title">My Title</h1>

            <div className="controls">
                <select>
                    <option value="daily">Daily</option>
                    <option value="weekly">Weekly</option>
                    <option value="monthly">Monthly</option>
                    <option value="annual">Annual</option>
                </select>
                <input type="text" placeholder="Money" />
            </div>
        </div>
    </div>
  );
}

export default Category;
