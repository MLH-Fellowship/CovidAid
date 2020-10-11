"""empty message

Revision ID: b51f68f90235
Revises: 96fbf8257612
Create Date: 2020-10-10 23:21:17.457311

"""
from alembic import op
import sqlalchemy as sa


# revision identifiers, used by Alembic.
revision = 'b51f68f90235'
down_revision = '96fbf8257612'
branch_labels = None
depends_on = None


def upgrade():
    # ### commands auto generated by Alembic - please adjust! ###
    op.add_column('users', sa.Column('points', sa.Integer(), nullable=True))
    # ### end Alembic commands ###


def downgrade():
    # ### commands auto generated by Alembic - please adjust! ###
    op.drop_column('users', 'points')
    # ### end Alembic commands ###